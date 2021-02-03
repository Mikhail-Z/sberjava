package cycle_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

//@Component
public class LoggerBean {
    private BusinessServiceBean businessServiceBean;
    private UUID uuid = UUID.randomUUID();

    @Autowired
    public void setBusinessServiceBean(BusinessServiceBean businessServiceBean) {
        this.businessServiceBean = businessServiceBean;
    }

    public void writeInfo(String message) {
        System.out.printf("%s - %s", LocalDateTime.now(), message);
    }

    public UUID getUuid() {
        return uuid;
    }
}
