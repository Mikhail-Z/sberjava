package task01_05.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MyApplicationContextConfiguration {

    /*@Bean
    public HelloWorldAnnotation helloWorldAnnotation() {
        return new HelloWorldAnnotation(logger());
    }*/

    public LoggerAnnotation logger() {
        return new ConsoleLoggerAnnotation();
    }
}
