package task01_05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task01_05.annotation.HelloWorldAnnotation;
import task01_05.annotation.LoggerAnnotation;
import task01_05.annotation.MyApplicationContextConfiguration;

public class Test {
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext xmlCtx = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldXml helloWorldXml = xmlCtx.getBean(HelloWorldXml.class);
        helloWorldXml.print();*/
        AnnotationConfigApplicationContext annotationCtx = new AnnotationConfigApplicationContext(
                MyApplicationContextConfiguration.class);
        HelloWorldAnnotation helloWorldAnnotation1 = annotationCtx.getBean(HelloWorldAnnotation.class);
        helloWorldAnnotation1.print();
        System.out.printf("helloWorld hashCode is always different because of prototype: %s\n", helloWorldAnnotation1);
        //!!! если бину логгера поставить prototype, а helloWorld -- singleton, то

        /*Trash.Service svc = xmlCtx.getBean(Trash.Service.class);
        svc.helloWorld();
        task01_05.Logger logger = annotationCtx.getBean(task01_05.Logger.class);
        logger.WriteInfo("hello, world");
        Trash.CbrProvider cbr = annotationCtx.getBean(Trash.CbrProvider.class);
        cbr.getBanksInfo();
        System.out.println(svc.getName());
        System.out.println(svc.getRepo());*/

        //task01_05.xml.HelloWorldXml helloWorld = xmlCtx.getBean(task01_05.xml.HelloWorldXml.class);
    }
}
