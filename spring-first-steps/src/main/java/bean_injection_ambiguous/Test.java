package bean_injection_ambiguous;

import bean_injection_ambiguous.annotation.ContextConfiguration;
import bean_injection_ambiguous.annotation.SomeDependantBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationCtx = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        //NoSuchBeanDefinitionException: No qualifying bean of type 'java.lang.String' available
        System.out.println(annotationCtx.getBean(SomeDependantBean.class).getNotUniqueBean().getName());
    }
}
