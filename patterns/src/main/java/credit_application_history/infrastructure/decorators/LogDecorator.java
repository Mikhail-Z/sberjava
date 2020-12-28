package credit_application_history.infrastructure.decorators;

import credit_application_history.core.entities.CreditApplication;
import credit_application_history.core.entities.Event;
import credit_application_history.core.services.IHistoryService;
import credit_application_history.infrastructure.services.LogService;

import java.util.UUID;

public class LogDecorator implements IHistoryService {

    private LogService logService;
    private IHistoryService wrappee;

    public LogDecorator(LogService logService, IHistoryService wrappee) {
        this.wrappee = wrappee;
        this.logService = logService;
    }

    @Override
    public void create(CreditApplication creditApplication) {
        logService.sendEvent(Event.BeginCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
        wrappee.create(creditApplication);
        logService.sendEvent(Event.EndCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
    }

    @Override
    public CreditApplication get(UUID id) {
        logService.sendEvent(Event.BeginGet, id);
        CreditApplication creditApplication = wrappee.get(id);
        logService.sendEvent(Event.EndGet, id);
        return creditApplication;
    }

    @Override
    public boolean update(CreditApplication creditApplication) {
        logService.sendEvent(Event.BeginUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        boolean result = wrappee.update(creditApplication);
        logService.sendEvent(Event.EndUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        return result;
    }
}
