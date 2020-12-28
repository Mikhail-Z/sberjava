package credit_application.handlers;

import credit_application.entities.CreditApplication;

public class CreditApprover extends BaseCreditApplicationHandler {
    @Override
    public void handle(CreditApplication creditApplication) {
        System.out.println("Заявка одобрена");
    }
}
