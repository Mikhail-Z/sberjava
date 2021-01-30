package bean_injection_ambiguous.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ContextConfiguration {

    @Bean(name = "notUniqueBean1")
    public NotUniqueBean notUniqueBean1() {
        return new NotUniqueBean("1");
    }

    @Bean(name = "notUniqueBean2")
    public NotUniqueBean notUniqueBean2() {
        return new NotUniqueBean("2");
    }

}
