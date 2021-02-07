package com.example.messagesapiboot.models.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource({
//        "classpath:application.properties",
//        "classpath:application-${spring.profiles.active}.properties"
//})
public class BaseSettings {
    @Value("${my.value}")
    private String value;

    public String getValue() {
        return value;
    }
}
