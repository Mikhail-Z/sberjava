package task01_05.xml;

public class HelloWorldXmlFactory {
    public HelloWorldXml create() {
        System.out.println("in factory class");
        return new HelloWorldXml();
    }
}
