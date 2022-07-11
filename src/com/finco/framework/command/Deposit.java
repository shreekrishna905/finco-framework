package com.finco.framework.command;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.IAccount;

public class Deposit implements Command{

    private FincoReceiver model;
    private double amount;
    private IAccount account;

    public Deposit(FincoReceiver model, double amount, IAccount account){
        this.model = model;
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void execute() {
        model.deposit(amount, account);
    }
}
