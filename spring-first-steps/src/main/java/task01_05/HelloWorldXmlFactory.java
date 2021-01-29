package task01_05;

public class HelloWorldXmlFactory {
    public HelloWorldXml create() {
        System.out.println("in factory class");
        return new HelloWorldXml();
    }
}
