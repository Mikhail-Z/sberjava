package notification_sending.commands;

import notification_sending.providers.EmailSender;
import notification_sending.providers.SmsSender;

import java.util.UUID;

public class SmsWithEmailNotificationSendingCommand implements Command {

    private static final String smsPattern =
            "Уважаемый клиент, Вам на почту была отправлена ссылка анкету для ознакомления с предложениями по кредиту\n";
    private static final String emailPattern =
            "Уважаемый клиент, предлагаем вам ознакомиться с предложениями по кредиту по ссылке %s\n";

    private final String link;
    private final SmsSender smsSender;
    private final EmailSender emailSender;
    private final UUID receiverUserId;

    public SmsWithEmailNotificationSendingCommand(SmsSender smsSender, EmailSender emailSender, UUID userId, String link) {
        this.smsSender = smsSender;
        this.emailSender = emailSender;
        this.receiverUserId = userId;
        this.link = link;
    }

    @Override
    public void execute() {
        emailSender.sendLetter(receiverUserId, String.format(emailPattern, link));
        smsSender.sendMessage(receiverUserId, smsPattern);
    }
}
