package aot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:spring.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true) //стратегия проксирования
public class ContextConfiguration {

}
