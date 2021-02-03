package cycle_dependency;

import org.springframework.beans.factory.annotation.Autowired;

public class BusinessServiceBean /*implements ApplicationContextAware, InitializingBean*/ {
    private LoggerBean logger;

    @Autowired
    public void setLogger(LoggerBean logger) {
        this.logger = logger;
    }

    public LoggerBean getLogger() {
        return logger;
    }
}
