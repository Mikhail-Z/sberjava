package cycle_dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class ContextConfiguration {

    @Bean
    public LoggerBean logger() {
        return new LoggerBean("app", 1);
    }

    /*@Bean
    public BusinessServiceBean service() {
        return new BusinessServiceBean( "api", 10, logger());
    }*/
}
