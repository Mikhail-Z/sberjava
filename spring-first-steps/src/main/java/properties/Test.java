package properties;

import inject_prototype_in_singleton_problem.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import properties.annotation.ContextConfiguration;
import properties.xml.ApiClient;

public class Test {
    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("properties_beans.xml");
        ApiClient apiClient = xmlContext.getBean(ApiClient.class);
        System.out.println(apiClient.getHost());

        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        properties.annotation.ApiClient apiClient1 = annotationContext.getBean(properties.annotation.ApiClient.class);
        System.out.println(apiClient1.getHost());
    }
}
