package org.nuradinnur.eyeoftheherald.component.ratelimiter;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Endpoints;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RateLimiter {

    private final Logger logger;
    private Map<Regions, Map<Endpoints, RateLimit>> rateLimits;

    RateLimiter() {
        this.rateLimits = new HashMap<>();
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Retryable(value = {RateLimiterException.class},
            maxAttempts = 1,
            backoff = @Backoff(delay = 0))
    public synchronized void acquire(Regions region, Endpoints endpoint) throws RateLimiterException {
        val applicationRateLimit = getRateLimit(region, null);
        val methodRateLimit = getRateLimit(region, endpoint);
        applicationRateLimit.acquire();
        methodRateLimit.acquire();
    }

    @Recover
    private void wait(RateLimiterException e, Regions region, Endpoints endpoint) {
        try {
            logger.info(e.getMessage());
            val sleepTime = getTimeRateLimitedNanoseconds(region, endpoint);
            logger.info("Sleeping for {} seconds.", (sleepTime / 1_000_000_000));
            Thread.sleep(sleepTime / 1_000_000, (int) (sleepTime % 1_000_000));
            getRateLimit(region, null).reset();
            getRateLimit(region, endpoint).reset();
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void update(Regions region, Endpoints endpoint, HttpHeaders headers) {
        val applicationRateLimit = getRateLimit(region, null);
        val methodRateLimit = getRateLimit(region, endpoint);
        applicationRateLimit.update(headers);
        methodRateLimit.update(headers);
    }

    private synchronized long getTimeRateLimitedNanoseconds(Regions region, Endpoints endpoint) {
        val applicationRateLimit = getRateLimit(region, null);
        val methodRateLimit = getRateLimit(region, endpoint);
        return applicationRateLimit.getTimeRateLimited() > methodRateLimit.getTimeRateLimited() ?
                methodRateLimit.getTimeRateLimited() : applicationRateLimit.getTimeRateLimited();
    }

    private synchronized RateLimit getRateLimit(Regions region, Endpoints endpoint) {
        if (!rateLimits.containsKey(region)) {
            rateLimits.put(region, new HashMap<>());
        }
        if (!rateLimits.get(region).containsKey(endpoint)) {
            rateLimits.get(region).put(endpoint, new RateLimit(region, endpoint));
        }
        return rateLimits.get(region).get(endpoint);
    }
}
