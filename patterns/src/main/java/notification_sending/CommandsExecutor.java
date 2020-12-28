package notification_sending;

import notification_sending.commands.Command;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CommandsExecutor {

    private ConcurrentLinkedQueue<Command> commands = new ConcurrentLinkedQueue<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void start() {
        while (true) {
            if (commands.isEmpty()) {
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    break;
                }

                continue;
            }

            Command command = commands.poll();
            try {
                command.execute();
            }
            catch (Exception e) {
                commands.add(command);
            }
        }
    }
}
