package com.finco.framework.account.entry;

import java.util.Date;

public abstract class Entry {
    private Date date;
    private double amount;
    private String name;

    public Entry(Date date, double amount, String name) {
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    abstract void process();
}
