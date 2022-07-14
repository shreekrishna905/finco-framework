package com.finco.framework.command;

import com.finco.framework.FincoManager;

public class AddInterest implements Command{

    private FincoManager fincoReceiver;

    public AddInterest(FincoManager fincoReceiver){
        this.fincoReceiver = fincoReceiver;
    }

    @Override
    public void execute() {
        fincoReceiver.addInterest();
    }
}
