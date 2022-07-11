package com.finco.framework;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.DepositeEntry;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.account.entry.WithdrawEntry;
import com.finco.framework.party.ICustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FincoReceiver {

    List<ICustomer> customers;
    List<IAccount> accounts;

    public FincoReceiver(){
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void withdraw(Double amount, IAccount account){
        Entry entry = new WithdrawEntry(LocalDate.now(), amount, "WITHDRAW");
        entry.process(account);
        account.addEntry(entry);
        ICustomer customer = account.getCustomer();
        customer.sendEmail();
    }

    public void deposit(Double amount, IAccount account){
        Entry entry = new DepositeEntry(LocalDate.now(), amount, "DEPOSIT");
        entry.process(account);
        account.addEntry(entry);
        ICustomer customer = account.getCustomer();
        customer.sendEmail();
    }


    public void createAccount(IAccount account, ICustomer customer){
        account.setCustomer(customer);
        customer.addAccount(account);
        this.customers.add(customer);
        this.accounts.add(account);
    }

    public void addInterest(){
       for (IAccount account: accounts){
           double interestAmount = account.getCurrentBalance() * account.getInterestRate();
           deposit(interestAmount,account);
       }
    }

    public void generateReport(){
        // TODO:
    }

    public void setReport(){
        // TODO:
    }

    public List<ICustomer> getCustomers() {
        return customers;
    }

    public List<IAccount> getAccounts() {
        return accounts;
    }



}
