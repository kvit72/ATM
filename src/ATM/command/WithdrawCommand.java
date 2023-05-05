package ATM.command;

import ATM.ConsoleHelper;
import ATM.CurrencyManipulator;
import ATM.CurrencyManipulatorFactory;
import ATM.exception.InterruptOperationException;
import ATM.exception.NotEnoughMoneyException;

import java.util.Map;

public class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Withdrawing...");

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            try {
                ConsoleHelper.writeMessage("Please specify integer amount for withdrawing.");
                String s = ConsoleHelper.readString();
                if (s == null) {
                    ConsoleHelper.writeMessage("Please specify valid positive integer amount for withdrawing.");
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
                            }

                            ConsoleHelper.writeMessage(String.format("%d %s was withdrawn successfully", amount, currencyCode));
                            break;
                        } else {
                            ConsoleHelper.writeMessage("Not enough money on your account, please try again");
                        }
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeMessage("Please specify valid positive integer amount for withdrawing.");
                    }
                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Exact amount is not available");
            }
        }
    }
}
