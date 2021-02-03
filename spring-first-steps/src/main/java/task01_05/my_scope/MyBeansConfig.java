package task01_05.my_scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class MyBeansConfig {
    @Scope(scopeName = "my")
    @Bean
    public MyBean foo() {
        return new MyBean("foo");
    }

    @Scope(scopeName = "my")
    @Bean
    public MyBean bar() {
        return new MyBean("bar");
    }
}
