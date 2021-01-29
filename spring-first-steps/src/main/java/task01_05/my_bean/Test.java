package task01_05.my_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyBeansConfig.class);
        ctx.register(MyScopeConfig.class);
        ctx.refresh();

        MyBean myBean1 = ctx.getBean("foo", MyBean.class);
        MyBean myBean2 = ctx.getBean("bar", MyBean.class);
        System.out.println(myBean1);
        System.out.println(myBean2);
        myBean1.sayHello();
        myBean2.sayHello();
    }
}
