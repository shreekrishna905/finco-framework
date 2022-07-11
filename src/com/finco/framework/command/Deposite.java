package com.finco.framework.command;

import com.finco.framework.FincoReceiver;

public class Deposite implements Command{

    private FincoReceiver model;

    public Deposite(FincoReceiver model){
        this.model = model;
    }

    @Override
    public void execute() {
        model.deposit();
    }
}
