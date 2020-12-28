package credit_application_history.infrastructure.decorators;

import credit_application_history.core.entities.CreditApplication;
import credit_application_history.core.entities.Event;
import credit_application_history.core.services.IHistoryService;
import credit_application_history.infrastructure.services.AuditService;

import java.util.UUID;

public class AuditDecorator implements IHistoryService {

    private AuditService auditService;
    private IHistoryService wrappee;

    public AuditDecorator(AuditService auditService, IHistoryService wrappee) {
        this.wrappee = wrappee;
        this.auditService = auditService;
    }

    @Override
    public void create(CreditApplication creditApplication) {
        auditService.sendEvent(Event.BeginCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
        wrappee.create(creditApplication);
        auditService.sendEvent(Event.EndCreate, creditApplication.getCreditInfo().getCreditHistory().getId());
    }

    @Override
    public CreditApplication get(UUID id) {
        auditService.sendEvent(Event.BeginGet, id);
        CreditApplication creditApplication = wrappee.get(id);
        auditService.sendEvent(Event.EndGet, id);
        return creditApplication;
    }

    @Override
    public boolean update(CreditApplication creditApplication) {
        auditService.sendEvent(Event.BeginUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        boolean result = wrappee.update(creditApplication);
        auditService.sendEvent(Event.EndUpdate, creditApplication.getCreditInfo().getCreditHistory().getId());
        return result;
    }
}
