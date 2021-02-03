package properties.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiClient {
    @Value("${apiClient.login}")
    private final String login;
    @Value("${apiClient.password}")
    private final String password;
    @Value("${apiClient.host}")
    private final String host;

    public ApiClient(String login, String password, String host) {
        this.login = login;
        this.password = password;
        this.host = host;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }
}
