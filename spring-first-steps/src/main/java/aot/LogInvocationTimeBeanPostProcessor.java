package aot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//настройка фабрики бинов
public class LogInvocationTimeBeanPostProcessor implements BeanPostProcessor {
    /*//до init метода
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }*/

    //после init метода
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SomeBean) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(SomeBean.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    long startTime = System.nanoTime();
                    try {
                        return method.invoke(o, objects);
                    }
                    finally {
                        System.out.println("время выполнения метода " + (System.nanoTime() - startTime));
                    }

                }
            });
        }

        return null;
    }
}
