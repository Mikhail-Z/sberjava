package credit_application_history.infrastructure.services;

import credit_application_history.core.entities.CreditApplication;
import credit_application_history.core.entities.Event;

import java.util.UUID;

public class AuditService {
    public void sendEvent(Event event, UUID id) {
        System.out.printf("аудит: событие %s: заявка %s\n", event, id);
    }
}
