package properties.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:my.properties")
@Configuration
public class ContextConfiguration {

    @Bean
    public ApiClient apiClient(@Value("${apiClient.login}") String login,
                               @Value("apiClient.password") String password,
                               @Value("apiClient.host") String host) {

        return new ApiClient(login, password, host);
    }
}
