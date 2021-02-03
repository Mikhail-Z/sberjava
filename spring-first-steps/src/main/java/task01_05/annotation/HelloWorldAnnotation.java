package task01_05.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HelloWorldAnnotation {
    private LoggerAnnotation logger;

    public HelloWorldAnnotation(LoggerAnnotation logger) {
        this.logger = logger;
        System.out.println("hello, world (annotation)");
    }

    @Lookup
    public LoggerAnnotation getLogger() {
        //return logger;
        return null;
    }

    public void print() {
        System.out.println(this.toString());

        System.out.println(logger.toString());
        System.out.println(getLogger().toString());
        System.out.println(getLogger().toString());
    }

}
