package credit_application;

import credit_application.entities.CreditApplication;
import credit_application.handlers.CreditApplicationDataFormatValidator;
import credit_application.handlers.CreditApplicationDataValueValidator;
import credit_application.handlers.CreditApplicationHandler;
import credit_application.handlers.CreditApprover;
import credit_application.providers.ClientInfoProvider;

public class Main {
    public static void main(String[] args) {
        CreditApplicationHandler dataFormatValidator = new CreditApplicationDataFormatValidator();
        CreditApplicationHandler dataValueValidator = new CreditApplicationDataValueValidator(new ClientInfoProvider());
        CreditApplicationHandler creditApprover = new CreditApprover();
        dataValueValidator.setNextHandler(creditApprover);
        dataFormatValidator.setNextHandler(dataValueValidator);
        dataFormatValidator.handle(new CreditApplication());
    }
}
