package postconstruct_predestroy;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        Repository repository = ctx.getBean(Repository.class);
        repository.save();
        ((BeanDefinitionRegistry)ctx.getBeanFactory()).removeBeanDefinition("repository");
    }
}