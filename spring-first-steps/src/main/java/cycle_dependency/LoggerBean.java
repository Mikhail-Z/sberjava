package cycle_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LoggerBean {
    private String applicationName;
    private int version;

    public LoggerBean(String applicationName, int version) {
        this.applicationName = applicationName;
        this.version = version;
    }

    /*public LoggerBean(BusinessServiceBean svc) {
        this.applicationName = svc.getApplicationName();
    }*/

    @Autowired
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void writeInfo(String message) {
        System.out.printf("%s: %s - %s", LocalDateTime.now(), applicationName, message);
    }
}
