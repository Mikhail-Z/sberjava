package credit_application_history.infrastructure.decorators;

import credit_application_history.core.services.IHistoryService;

public abstract class BaseDecorator implements IHistoryService {

    protected IHistoryService wrappee;

    public BaseDecorator(IHistoryService wrappee) {
        this.wrappee = wrappee;
    }
}
