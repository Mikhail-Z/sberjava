package postconstruct_predestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ContextConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }
}
