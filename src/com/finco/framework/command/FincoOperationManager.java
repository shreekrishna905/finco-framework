package com.finco.framework.command;

public class FincoOperationManager {

    private Command command;

    public void submit(){
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
