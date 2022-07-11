package com.finco.framework.account.entry;

import com.finco.framework.account.IAccount;

import java.time.LocalDate;

public class WithdrawEntry extends Entry {

    public WithdrawEntry(LocalDate date, double amount, String name) {
        super(date, amount, "WITHDRAW");
    }

    @Override
    public void process(IAccount account) {
        account.withdraw(getAmount());
    }
}
