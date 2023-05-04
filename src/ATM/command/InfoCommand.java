package ATM.command;

import ATM.ConsoleHelper;
import ATM.CurrencyManipulator;
import ATM.CurrencyManipulatorFactory;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Information:");
        boolean hasMoney = false;
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney) {
            ConsoleHelper.writeMessage("No money available.");
        }

    }
}
