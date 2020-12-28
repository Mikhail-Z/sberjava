package notification_sending.providers;

import java.util.UUID;

public class EmailSender {
    public void sendLetter(UUID userId, String text) {
        System.out.printf("Отправляю клиенту %s письмо: %s", userId, text);
    }
}
