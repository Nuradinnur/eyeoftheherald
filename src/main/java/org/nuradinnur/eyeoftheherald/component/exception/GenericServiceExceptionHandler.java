package org.nuradinnur.eyeoftheherald.component.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GenericServiceExceptionHandler implements AsyncUncaughtExceptionHandler {

    private final Logger logger;

    public GenericServiceExceptionHandler() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        e.printStackTrace();
    }
}