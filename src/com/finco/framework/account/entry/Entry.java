package com.finco.framework.account.entry;

import com.finco.framework.account.IAccount;

import java.time.LocalDate;
import java.util.Date;

public abstract class Entry {
    private LocalDate date;
    private double amount;
    private String name;

    public Entry(LocalDate date, double amount, String name) {
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void process(IAccount account);
}
