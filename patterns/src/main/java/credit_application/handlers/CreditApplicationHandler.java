package credit_application.handlers;

import credit_application.entities.CreditApplication;

public interface CreditApplicationHandler {
    void handle(CreditApplication creditApplication);
    void setNextHandler(CreditApplicationHandler nextHandler);
}
