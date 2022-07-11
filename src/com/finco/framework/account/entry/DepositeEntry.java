package com.finco.framework.account.entry;

import com.finco.framework.account.IAccount;

import java.util.Date;

public class DepositeEntry extends Entry {

    public DepositeEntry(Date date, double amount, String name) {
        super(date, amount, name);
    }

    @Override
    public void process(IAccount account, double amount) {
        account.deposit(amount);
    }
}
