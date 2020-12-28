package credit_application.handlers;

import credit_application.entities.CreditApplication;

public abstract class BaseCreditApplicationHandler implements CreditApplicationHandler {
    protected CreditApplicationHandler nextHandler;

    @Override
    public void setNextHandler(CreditApplicationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(CreditApplication creditApplication) {
        if (this.nextHandler != null) {
            this.nextHandler.handle(creditApplication);
        }
    }
}
