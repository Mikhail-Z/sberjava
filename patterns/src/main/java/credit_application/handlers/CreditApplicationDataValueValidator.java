package credit_application.handlers;

import credit_application.providers.ClientInfoProvider;
import credit_application.entities.CreditApplication;

public class CreditApplicationDataValueValidator extends BaseCreditApplicationHandler {

    private ClientInfoProvider clientInfoProvider;

    public CreditApplicationDataValueValidator(ClientInfoProvider clientInfoProvider) {
        this.clientInfoProvider = clientInfoProvider;
    }

    @Override
    public void handle(CreditApplication creditApplication) {
        if (validateDataValue(creditApplication)) {
            System.out.println("Комплаенс клиента завершен успешно");
            super.handle(creditApplication);
        }
    }

    /***
     * логика проверки правильности заполненности даннных клиента и условий кредита
     * @param creditApplication кредитная заявка
     * @return пройдена ли валидация
     */
    private boolean validateDataValue(CreditApplication creditApplication) {
        return clientInfoProvider.checkCreditHistory(creditApplication.getClientInfo());
    }
}
