package org.nuradinnur.eyeoftheherald.controller.exception;

import lombok.Getter;

import java.util.Date;


public class ExceptionalHttpStatusCodeResponse extends ExceptionalResponse {

    @Getter
    private final int statusCode;

    public ExceptionalHttpStatusCodeResponse(Date timestamp, String message, String details, int statusCode) {
        super(timestamp, message, details);
        this.statusCode = statusCode;
    }
}
