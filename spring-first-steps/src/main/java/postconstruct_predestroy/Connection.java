package postconstruct_predestroy;

import org.springframework.stereotype.Component;

@Component
public class Connection {
    public void close() {
        System.out.println("closing connection...");
    }

    public void open() {
        System.out.println("opening connection...");
    }
}
