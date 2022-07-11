package com.finco.framework.command;

import com.finco.framework.FincoReceiver;

public class AddInterest implements Command{

    private FincoReceiver fincoReceiver;

    public AddInterest(FincoReceiver fincoReceiver){
        this.fincoReceiver = fincoReceiver;
    }

    @Override
    public void execute() {
        fincoReceiver.addInterest();
    }
}
