package credit_application_history.infrastructure.decorators;

import credit_application_history.core.entities.CreditApplication;
import credit_application_history.core.entities.Event;
import credit_application_history.core.services.IHistoryService;
import credit_application_history.infrastructure.services.LogService;
import credit_application_history.infrastructure.services.MonitoringService;

import java.util.UUID;

public class MonitoringDecorator implements IHistoryService {

    private MonitoringService monitoringService;
    private IHistoryService wrappee;

    public MonitoringDecorator(MonitoringService monitoringService,  IHistoryService wrappee) {
        this.monitoringService = monitoringService;
        this.wrappee = wrappee;
    }

    @Override
    public void create(CreditApplication creditApplication) {
        monitoringService.sendEvent(Event.BeginCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
        wrappee.create(creditApplication);
        monitoringService.sendEvent(Event.EndCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
    }

    @Override
    public CreditApplication get(UUID id) {
        monitoringService.sendEvent(Event.BeginGet, id);
        CreditApplication creditApplication = wrappee.get(id);
        monitoringService.sendEvent(Event.EndGet, id);
        return creditApplication;
    }

    @Override
    public boolean update(CreditApplication creditApplication) {
        monitoringService.sendEvent(Event.BeginUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        boolean result = wrappee.update(creditApplication);
        monitoringService.sendEvent(Event.EndUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        return result;
    }
}
