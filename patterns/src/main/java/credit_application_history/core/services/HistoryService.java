package credit_application_history.core.services;

import credit_application_history.core.entities.CreditApplication;

import java.util.UUID;

public class HistoryService implements IHistoryService {
    @Override
    public void create(CreditApplication creditApplication) {
        System.out.println("внутри метода create");
    }

    @Override
    public CreditApplication get(UUID id) {
        System.out.println("внутри метода get");
        return null;
    }

    @Override
    public boolean update(CreditApplication creditApplication) {
        System.out.println("внутри метода update");

        return false;
    }
}
