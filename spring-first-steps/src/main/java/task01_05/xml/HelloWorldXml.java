package task01_05.xml;

public class HelloWorldXml {

    private LoggerXml logger;

    public HelloWorldXml() {
        System.out.println("in default constructor");
        this.logger = new ConsoleXmlLogger("Default");
    }

    public HelloWorldXml(LoggerXml logger) {
        System.out.println("in constructor");
        this.logger = logger;
    }

    public void print() {
        this.logger.writeInfo("hello, world");
    }

    public static HelloWorldXml create() {
        System.out.println("in static method");
        return new HelloWorldXml();
    }
}
