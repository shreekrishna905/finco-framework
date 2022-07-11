package com.finco.framework.account.entry;

import java.util.Date;

public class DepositeEntry extends Entry {

    public DepositeEntry(Date date, double amount, String name) {
        super(date, amount, name);
    }

    @Override
    void process() {
        // TODO: Process the entry
    }
}
