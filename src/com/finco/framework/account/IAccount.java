package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;
import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

public abstract class IAccount {

    protected ICustomer customer;

    public IAccount(ICustomer customer){
        this.customer = customer;
    }
    protected abstract void addEntry(Entry entry);
    public abstract String generateReport();
    public abstract String getBalance();
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public abstract String getAccountNumber();

    public String getAccountType(){return "";}

    public double getInterestRate(){ return 0.0; };

    protected ICustomer getCustomer(){ return customer;}

    public abstract double getCurrentBalance();

    protected void setCustomer(ICustomer customer) {
        this.customer = customer;
    }
}
