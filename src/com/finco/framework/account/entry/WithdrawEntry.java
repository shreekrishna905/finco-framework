package com.finco.framework.account.entry;

import java.util.Date;

public class WithdrawEntry extends Entry {

    public WithdrawEntry(Date date, double amount, String name) {
        super(date, amount, name);
    }

    @Override
    void process() {
        // TODO: Process the entry
    }
}
