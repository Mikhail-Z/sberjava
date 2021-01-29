package cycle_dependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Component
/*public class BusinessServiceBean implements ApplicationContextAware, InitializingBean {
    private LoggerBean logger;
    private String applicationName;
    private int frequency;
    private ApplicationContext context;

    //@Lazy LoggerBean logger -- не сработало, выкидывает BeanCreationException
    public BusinessServiceBean(String applicationName, int frequency, LoggerBean logger) {
        this.frequency = frequency;
        this.logger = logger;
        this.applicationName = applicationName;
    }

    public LoggerBean getLogger() {
        return logger;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger = context.getBean(LoggerBean.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
*/