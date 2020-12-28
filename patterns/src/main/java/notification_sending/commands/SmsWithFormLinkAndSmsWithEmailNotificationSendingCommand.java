package notification_sending.commands;

public class SmsWithFormLinkAndSmsWithEmailNotificationSendingCommand implements Command{
    private final SmsWithFormLinkSendingCommand smsWithFormLinkSendingCommand;
    private final SmsWithEmailNotificationSendingCommand smsWithEmailNotificationSendingCommand;

    public SmsWithFormLinkAndSmsWithEmailNotificationSendingCommand(
            SmsWithFormLinkSendingCommand smsWithFormLinkSendingCommand,
            SmsWithEmailNotificationSendingCommand smsWithEmailNotificationSendingCommand) {

        this.smsWithFormLinkSendingCommand = smsWithFormLinkSendingCommand;
        this.smsWithEmailNotificationSendingCommand = smsWithEmailNotificationSendingCommand;
    }

    @Override
    public void execute() {
        smsWithFormLinkSendingCommand.execute();
        smsWithEmailNotificationSendingCommand.execute();
    }
}
