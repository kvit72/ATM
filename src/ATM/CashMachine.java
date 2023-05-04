package ATM;

import ATM.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }
}
