package ATM.command;

import ATM.ConsoleHelper;
import ATM.exception.InterruptOperationException;

public class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");
        String result = ConsoleHelper.readString();
        if (result != null && "y".equals(result.toLowerCase())) {
            ConsoleHelper.writeMessage("Thank you for visiting ATM. Good luck!");
        } else {

        }
    }
}
