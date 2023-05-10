package ATM.command;

import ATM.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;
}
