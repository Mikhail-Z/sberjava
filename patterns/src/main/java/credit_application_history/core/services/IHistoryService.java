package credit_application_history.core.services;

import credit_application_history.core.entities.CreditApplication;

import java.util.UUID;

public interface IHistoryService {
    void create(CreditApplication creditApplication);
    CreditApplication get(UUID id);
    boolean update(CreditApplication creditApplication);
}
