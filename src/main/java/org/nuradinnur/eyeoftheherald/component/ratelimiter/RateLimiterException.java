package org.nuradinnur.eyeoftheherald.component.ratelimiter;

import lombok.Getter;

public class RateLimiterException extends RuntimeException {

    @Getter
    private final long retryAfter;

    public RateLimiterException(String message, long retryAfter) {
        super(message);
        this.retryAfter = retryAfter;
    }
}