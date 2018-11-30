package org.nuradinnur.eyeoftheherald.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook implements ApplicationContextAware {

    private final Logger logger;
    private ApplicationContext context;

    public ShutdownHook(ApplicationContext context) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.context = context;
    }

    public void shutdownExceptionally(Throwable e) {
        logger.error(e.getMessage());
        Throwable c = e.getCause();
        logger.error(c.getMessage());
        while (c.getCause() != null) {
            c = c.getCause();
            logger.error(e.getCause().toString());
        }
        ((ConfigurableApplicationContext) context).close();
    }

    public void shutdownGracefully() {
        logger.info("Shutting down gracefully.");
        ((ConfigurableApplicationContext) context).close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
