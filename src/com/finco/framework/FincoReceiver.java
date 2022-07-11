package com.finco.framework;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.DepositeEntry;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.account.entry.WithdrawEntry;
import com.finco.framework.observer.Observer;
import com.finco.framework.observer.Subject;
import com.finco.framework.party.ICustomer;
import com.finco.framework.party.person.IPerson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class FincoReceiver implements Subject {

    List<ICustomer> customers;
    List<IAccount> accounts;

    public FincoReceiver(){
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void withdraw(Double amount, IAccount account){
        Date date = new Date();
        Entry entry = new WithdrawEntry(date, amount, "WITHDRAW");
        entry.process(account, amount);

        account.addEntry(entry);

        ICustomer customer = account.getCustomer();
        customer.sendEmail();
    }

    public void deposit(Double amount, IAccount account){
        Date date = new Date();
        Entry entry = new DepositeEntry(date, amount, "DEPOSIT");
        entry.process(account, amount);

        account.addEntry(entry);

        ICustomer customer = account.getCustomer();
        customer.sendEmail();
    }

    public void createPerson(String accountNumber, ICustomer person){
        Account account = new Account(accountNumber, 0.0);
        account.setCustomer(person);
        person.addAccount(account);
        this.customers.add(person);
        this.accounts.add(account);
    }

    public void createCompany(String accountNumber, ICustomer customer){
        Account account = new Account(accountNumber, 0.0);
        account.setCustomer(customer);
        customer.addAccount(account);
        this.customers.add(customer);
        this.accounts.add(account);

    }

    public void createAccount(){
        // TODO:
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


    @Override
    public void addObserver(Observer observer) {
        // TODO:
    }

    @Override
    public void removeObserver(Observer observer) {
        // TODO:
    }

    @Override
    public void notifyObserver() {
        // TODO:
    }


}
