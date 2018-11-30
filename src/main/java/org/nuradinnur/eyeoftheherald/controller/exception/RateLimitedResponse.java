package org.nuradinnur.eyeoftheherald.controller.exception;

import lombok.Getter;

import java.util.Date;


public class RateLimitedResponse extends ExceptionalResponse {

    @Getter
    private final long retryIn;

    public RateLimitedResponse(Date timestamp, String message, String details, long retryIn) {
        super(timestamp, message, details);
        this.retryIn = retryIn;
    }
}
