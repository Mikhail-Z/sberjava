package postconstruct_predestroy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Repository {
    private final Connection connection;

    public Repository(Connection connection) {
        this.connection = connection;
    }

    @PostConstruct
    private void openConnection() {
        connection.open();
    }
    public void save() {
        System.out.println("in save method");
    }

    @PreDestroy
    private void closeConnection() {
        connection.close();
    }
}
