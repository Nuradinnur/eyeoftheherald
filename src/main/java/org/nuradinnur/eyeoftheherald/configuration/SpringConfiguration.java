package org.nuradinnur.eyeoftheherald.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import lombok.val;
import org.nuradinnur.eyeoftheherald.component.ShutdownHook;
import org.nuradinnur.eyeoftheherald.component.exception.CrawlerResponseErrorHandler;
import org.nuradinnur.eyeoftheherald.component.exception.GenericServiceExceptionHandler;
import org.nuradinnur.eyeoftheherald.component.util.EncodedResourceResolver;
import org.nuradinnur.eyeoftheherald.component.util.QueuesConverter;
import org.nuradinnur.eyeoftheherald.component.util.RegionsConverter;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
@EnableRetry
public class SpringConfiguration implements AsyncConfigurer, WebMvcConfigurer {

    // TODO: Clean up @Beans.  Many of these do not have to be specifically constructed here (@Autowired)

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/images/**")
//                .addResourceLocations("file:" + gameVersioningService.getDataDragonFolder().toString() + "/img/")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/static/datadragon/8.23.1/img/")
                .resourceChain(true)
                .addResolver(encodedPathResourceResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new RegionsConverter());
        registry.addConverter(new QueuesConverter());
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new GenericServiceExceptionHandler();
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(11);
        executor.setMaxPoolSize(11);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("Crawler-");
        executor.initialize();
        return executor;
    }

    @Bean
    public RestTemplate restTemplate(CrawlerResponseErrorHandler crawlerResponseErrorHandler, ShutdownHook shutdownHook) {
        val restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(crawlerResponseErrorHandler);
        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper(HandlerInstantiator instantiator) {
        val builder = new Jackson2ObjectMapperBuilder();
        builder.handlerInstantiator(instantiator);
        val mapper = builder.build();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

    @Bean
    public EncodedResourceResolver encodedPathResourceResolver() {
        return new EncodedResourceResolver();
    }

    @Bean
    public HandlerInstantiator handlerInstantiator(ApplicationContext context) {
        return new SpringHandlerInstantiator(context.getAutowireCapableBeanFactory());
    }
}

