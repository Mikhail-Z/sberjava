package task01_05.xml;

public class ConsoleXmlLogger implements LoggerXml {

    private String prefix;

    public ConsoleXmlLogger(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void writeInfo(String message) {
        System.out.printf("%s - Info: %s\n", prefix, message);
    }

    @Override
    public void writeWarn(String message) {
        System.out.printf("%s - Warn: %s\n", prefix, message);
    }

    @Override
    public void writeError(String message) {
        System.out.printf("%s - Error: %s\n", prefix, message);
    }
}
