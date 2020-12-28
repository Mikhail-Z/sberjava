package credit_application_history.infrastructure.services;

import credit_application_history.core.entities.CreditApplication;
import credit_application_history.core.entities.Event;

import java.util.UUID;

public class MonitoringService {
    public void sendEvent(Event event, UUID id) {
        System.out.printf("мониторинг: событие %s: заявка %s\n", event, id);
    }
}
