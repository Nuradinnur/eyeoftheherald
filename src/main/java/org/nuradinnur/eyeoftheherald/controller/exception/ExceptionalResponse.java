package org.nuradinnur.eyeoftheherald.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public abstract class ExceptionalResponse {
    private final Date timestamp;
    private final String message;
    private final String details;
}
