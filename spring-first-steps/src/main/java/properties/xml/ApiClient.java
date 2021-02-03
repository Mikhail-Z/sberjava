package properties.xml;

import org.springframework.stereotype.Component;

@Component
public class ApiClient {
    private final String login;

    private final String password;

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
