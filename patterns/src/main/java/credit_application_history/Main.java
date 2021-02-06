package credit_application_history;

import credit_application_history.core.services.HistoryService;
import credit_application_history.core.services.IHistoryService;
import credit_application_history.infrastructure.decorators.AuditDecorator;
import credit_application_history.infrastructure.decorators.LogDecorator;
import credit_application_history.infrastructure.decorators.MonitoringDecorator;
import credit_application_history.infrastructure.services.AuditService;
import credit_application_history.infrastructure.services.LogService;
import credit_application_history.infrastructure.services.MonitoringService;

import java.util.UUID;

public class Main {
    
    
    public static void main(String[] args) {
        LogService logService = new LogService();
        MonitoringService monitoringService = new MonitoringService();
        AuditService auditService = new AuditService();

        IHistoryService historyService = new HistoryService();
        IHistoryService logDecorator = new LogDecorator(logService, historyService);
        IHistoryService monitoringDecorator = new MonitoringDecorator(monitoringService, logDecorator);
        IHistoryService auditDecorator = new AuditDecorator(auditService, monitoringDecorator);
        auditDecorator.get(UUID.randomUUID());
    }
}
