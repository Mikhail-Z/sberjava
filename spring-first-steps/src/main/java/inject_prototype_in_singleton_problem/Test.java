package inject_prototype_in_singleton_problem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(singletonBean1); //same
        System.out.println(singletonBean2); //same
        System.out.println(prototypeBean1); //different
        System.out.println(prototypeBean2); //different
    }
}
