package ATM.command;

import ATM.CashMachine;
import ATM.ConsoleHelper;
import ATM.CurrencyManipulator;
import ATM.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

public class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

    }
}
