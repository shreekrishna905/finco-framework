package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;
import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount{
    private String accountNumber;
    private double currentBalance;
    private ICustomer customer;
    private List<Entry> entries;

    public Account(String accountNumber, double currentBalance){
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.entries = new ArrayList<>();
    }

    @Override
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    @Override
    public String generateReport() {
        // TODO:
        return null;
    }

    @Override
    public String getBalance() {
        // TODO:
        return null;
    }

    @Override
    public void deposit(double amount) {
        currentBalance += amount;
    }

    @Override
    public void withdraw(double amount) {
        currentBalance -= amount;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public ICustomer getCustomer() {
        return customer;
    }


    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    @Override
    public double getCurrentBalance() {
        return currentBalance;
    }


}
