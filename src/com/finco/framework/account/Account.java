package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;
import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

public class Account implements IAccount{

    private String accountNumber;

    private double currentBalance;

    private ICustomer customer;

    public Account(String accountNumber, double currentBalance){
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    @Override
    public void addEntry(Entry entry) {

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
    public void deposite() {
        // TODO:

    }

    @Override
    public void withdraw() {
        // TODO:
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
