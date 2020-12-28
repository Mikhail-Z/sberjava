package notification_sending;

import notification_sending.commands.Command;
import notification_sending.commands.SmsWithEmailNotificationSendingCommand;
import notification_sending.commands.SmsWithFormLinkAndSmsWithEmailNotificationSendingCommand;
import notification_sending.commands.SmsWithFormLinkSendingCommand;
import notification_sending.providers.EmailSender;
import notification_sending.providers.SmsSender;

import java.util.UUID;

public class NotificationSendingService {
    public static void main(String[] args) {
        SmsSender smsSender = new SmsSender();
        EmailSender emailSender = new EmailSender();
        UUID receiverUserId = UUID.randomUUID();

        CommandsExecutor commandsExecutor = new CommandsExecutor();
        final String link = "https://www.example.com";
        SmsWithFormLinkSendingCommand command1 = new SmsWithFormLinkSendingCommand(smsSender, receiverUserId, link);
        SmsWithEmailNotificationSendingCommand command2 = new SmsWithEmailNotificationSendingCommand(smsSender, emailSender, receiverUserId, link);
        Command command12 = new SmsWithFormLinkAndSmsWithEmailNotificationSendingCommand(
                command1,
                command2);
        commandsExecutor.addCommand(command1);
        commandsExecutor.addCommand(command2);
        commandsExecutor.addCommand(command12);
        commandsExecutor.start();
    }

}
