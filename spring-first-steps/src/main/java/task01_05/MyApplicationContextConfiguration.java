package task01_05;

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

    @Bean
    public LoggerAnnotation logger() {
        return new ConsoleLoggerAnnotation();
    }
}
