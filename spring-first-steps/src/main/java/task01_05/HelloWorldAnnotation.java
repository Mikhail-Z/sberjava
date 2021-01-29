package task01_05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloWorldAnnotation {
    private LoggerAnnotation logger;

    public HelloWorldAnnotation(LoggerAnnotation logger) {
        this.logger = logger;
        System.out.println("hello, world (annotation)");
    }

    public LoggerAnnotation getLogger() {
        return logger;
    }
}
