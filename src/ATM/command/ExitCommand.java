package ATM.command;

import ATM.CashMachine;
import ATM.ConsoleHelper;
import ATM.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.exit");
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
