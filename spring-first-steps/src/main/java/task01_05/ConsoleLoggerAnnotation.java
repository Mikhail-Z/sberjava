package task01_05;


import java.util.UUID;

public class ConsoleLoggerAnnotation implements LoggerAnnotation {

    private final UUID uuid = UUID.randomUUID();

    @Override
    public void writeInfo(String message) {
        System.out.printf("Info: %s\n", message);
    }

    @Override
    public void writeWarn(String message) {
        System.out.printf("Warn: %s\n", message);
    }

    @Override
    public void writeError(String message) {
        System.out.printf("Error: %s\n", message);
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }
}
