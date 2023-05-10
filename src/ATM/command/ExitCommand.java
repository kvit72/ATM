package ATM.command;

import ATM.CashMachine;
import ATM.ConsoleHelper;
import ATM.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String result = ConsoleHelper.readString();
        if (result != null && "y".equals(result.toLowerCase())) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        } else {

        }
    }
}
