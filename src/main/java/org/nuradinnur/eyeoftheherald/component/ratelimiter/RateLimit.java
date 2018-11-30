package org.nuradinnur.eyeoftheherald.component.ratelimiter;

import lombok.val;
import org.nuradinnur.eyeoftheherald.constant.Endpoints;
import org.nuradinnur.eyeoftheherald.constant.Regions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.ArrayList;
import java.util.List;

class RateLimit {

    private static final String X_APP_RATE_LIMIT_HEADER = "X-App-Rate-Limit";
    private static final String X_METHOD_RATE_LIMIT_HEADER = "X-Method-Rate-Limit";
    private static final String X_APP_RATE_LIMIT_COUNT_HEADER = "X-App-Rate-Limit-Count";
    private static final String X_METHOD_RATE_LIMIT_COUNT_HEADER = "X-Method-Rate-Limit-Count";

    private Regions region;
    private Endpoints endpoint;
    private List<RateLimitCounter> counters;

    RateLimit(Regions region, Endpoints endpoint) {
        this.region = region;
        this.endpoint = endpoint;
        this.counters = new ArrayList<>();
    }

    synchronized long getTimeRateLimited() {
        long time = Long.MAX_VALUE;
        for (val counter : counters) {
            if (counter.getCount() >= counter.getLimit()) {
                time = counter.getTimeToNextPeriodNanoseconds();
            }
        }
        return time;
    }

    synchronized void acquire() throws RateLimiterException {
        String rateLimitTypeString;
        if (endpoint == null) {
            rateLimitTypeString = "application";
        } else {
            rateLimitTypeString = "endpoint " + endpoint + " (" + endpoint.getPattern() + ")";
        }
        for (val counter : counters) {
            if (!counter.incrementCount()) {
                throw new RateLimiterException("The request could not be made. The "
                        + rateLimitTypeString + " is currently rate limited in " + region.name()
                        + " for the next " + counter.getTimeToNextPeriodSeconds() + " seconds.",
                        counter.getTimeToNextPeriodSeconds());
            }
        }
    }

    synchronized void update(HttpHeaders headers) {
        String countHeaders;
        String limitHeaders;
        if (endpoint == null
                && headers.containsKey(X_APP_RATE_LIMIT_HEADER)
                && headers.containsKey(X_APP_RATE_LIMIT_COUNT_HEADER)) {
            countHeaders = headers.get(X_APP_RATE_LIMIT_COUNT_HEADER).get(0);
            limitHeaders = headers.get(X_APP_RATE_LIMIT_HEADER).get(0);
        } else if (endpoint != null
                && headers.containsKey(X_METHOD_RATE_LIMIT_HEADER)
                && headers.containsKey(X_METHOD_RATE_LIMIT_COUNT_HEADER)) {
            countHeaders = headers.get(X_METHOD_RATE_LIMIT_COUNT_HEADER).get(0);
            limitHeaders = headers.get(X_METHOD_RATE_LIMIT_HEADER).get(0);
        } else {
            throw new HttpMessageNotReadableException("Riot API response headers do not contain " +
                    "enough information about the rate limit.\n" + headers.toString());
        }
        val countSegments = countHeaders.split("[,:]");
        val limitSegments = limitHeaders.split("[,:]");
        for (int i = 0; i < countSegments.length / 2; i++) {
            if (counters.size() < countSegments.length / 2) {
                counters.add(new RateLimitCounter(0, 0));
            }
            counters.get(i).setLimit(Integer.parseInt(limitSegments[2 * i]));
            counters.get(i).setCount(Integer.parseInt(countSegments[2 * i]));
            counters.get(i).setPeriod(Integer.parseInt(countSegments[2 * i + 1]));
        }
        for (val counter : counters) {
            if (counter.getPeriodEndNanoseconds() < System.nanoTime()) {
                counter.setPeriodStartTimeNanoseconds(System.nanoTime());
            }
        }
    }

    synchronized void reset() {
        for (val counter : counters) {
            if (counter.getTimeToNextPeriodNanoseconds() == 0) {
                counter.resetCount();
            }
        }
    }
}