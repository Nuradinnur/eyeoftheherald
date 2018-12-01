package org.nuradinnur.eyeoftheherald.controller.exception;

import lombok.val;
import org.nuradinnur.eyeoftheherald.component.ShutdownHook;
import org.nuradinnur.eyeoftheherald.component.ratelimiter.RateLimiterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class DataCollectionControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final ShutdownHook shutdownHandler;
    private final Logger logger;

    public DataCollectionControllerExceptionHandler(ShutdownHook shutdownHandler) {
        this.shutdownHandler = shutdownHandler;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @ExceptionHandler(RateLimiterException.class)
    public final ResponseEntity<ExceptionalResponse> handleRateLimiterExceptions(RateLimiterException e, WebRequest request) {
        val errorDetails = new RateLimitedResponse(new Date(),
                e.getMessage(),
                request.getDescription(false),
                e.getRetryAfter());
        return new ResponseEntity<>(errorDetails, HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public final ResponseEntity<ExceptionalResponse> handle(HttpStatusCodeException e, WebRequest request) {
        val statusCode = e.getStatusCode();
        val errorDetails = new ExceptionalHttpStatusCodeResponse(new Date(),
                e.getMessage(),
                request.getDescription(false),
                e.getStatusCode().value());
        try {
            return new ResponseEntity<>(errorDetails, statusCode);
        }
        finally {
            if (statusCode == HttpStatus.UNAUTHORIZED
            || statusCode == HttpStatus.FORBIDDEN
            || statusCode == HttpStatus.UNSUPPORTED_MEDIA_TYPE
            || statusCode == HttpStatus.TOO_MANY_REQUESTS) {
                // Should NEVER happen.  Shut down so that we don't get blacklisted.
                logger.error("Received code: " + statusCode + ", trying to shutdown gracefully...");
                shutdownHandler.shutdownExceptionally(e);
            }
        }
    }
}