package com.example.messagesapiboot;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/*
@Configuration
@ComponentScan(basePackages = "com.example.messagesapiboot.*")
public class PropertiesUtil implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public String load(String propertyName)
    {
        return environment.getRequiredProperty(propertyName);
    }
}*/