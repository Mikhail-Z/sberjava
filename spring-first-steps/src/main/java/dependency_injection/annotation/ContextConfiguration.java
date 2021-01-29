package dependency_injection.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class ContextConfiguration {

    /*@Bean
    public School school() {
        return new School(1, Arrays.asList(this.pupil(), this.pupil(), this.pupil()));
    }*/

    @Bean
    public Pupil pupil() {
        return new Pupil("mike", 7);
    }
}
