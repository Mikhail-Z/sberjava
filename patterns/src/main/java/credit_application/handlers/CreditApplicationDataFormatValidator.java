package credit_application.handlers;

import credit_application.entities.CreditApplication;

public class CreditApplicationDataFormatValidator extends BaseCreditApplicationHandler {
    @Override
    public void handle(CreditApplication creditApplication) {
        if (validateDataFormat(creditApplication)) {
            System.out.println("Проверка правильности заполненности завершена успешно");
            super.handle(creditApplication);
        }
    }

    /***
     * логика проверки правильности формата заполненности даннных клиента и условий кредита
     * @param creditApplication кредитная заявка
     * @return пройдена ли валидация
     */
    private boolean validateDataFormat(CreditApplication creditApplication) {
        return true;
    }
}
