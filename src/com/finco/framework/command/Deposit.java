package com.finco.framework.command;

import com.finco.framework.FincoManager;
import com.finco.framework.account.IAccount;

public class Deposit implements Command{

    private FincoManager model;
    private double amount;
    private IAccount account;

    public Deposit(FincoManager model, double amount, IAccount account){
        this.model = model;
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void execute() {
        model.deposit(amount, account);
    }
}
