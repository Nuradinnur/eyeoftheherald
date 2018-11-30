package org.nuradinnur.eyeoftheherald.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Getter
@Setter
@Configuration
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix = "riot.api")
public class DataAccessConfiguration {

    private String key;
    private String gameDataUriPrefix;
    private String dataDragonUriPrefix;
}