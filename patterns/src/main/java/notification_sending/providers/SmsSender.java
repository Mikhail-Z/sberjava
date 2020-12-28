package notification_sending.providers;

import java.util.UUID;

public class SmsSender {
    public void sendMessage(UUID userId, String text) {
        System.out.printf("Отправляю клиенту %s sms-сообщение: %s", userId, text);
    }
}
