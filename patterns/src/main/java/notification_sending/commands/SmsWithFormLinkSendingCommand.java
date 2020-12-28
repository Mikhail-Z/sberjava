package notification_sending.commands;

import notification_sending.providers.SmsSender;

import java.util.UUID;

public class SmsWithFormLinkSendingCommand implements Command {

    private static final String smsPattern =
            "Уважаемый клиент, предлагаем вам ознакомиться с предложениями по кредиту по ссылке %s\n";

    private final String link;
    private final SmsSender smsSender;
    private final UUID receiverUserId;

    public SmsWithFormLinkSendingCommand(SmsSender smsSender, UUID userId, String link) {
        this.smsSender = smsSender;
        this.receiverUserId = userId;
        this.link = link;
    }

    @Override
    public void execute() {
        smsSender.sendMessage(receiverUserId, String.format(smsPattern, link));
    }
}
