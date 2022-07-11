package com.finco.framework;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.observer.Observer;
import com.finco.framework.observer.Subject;
import com.finco.framework.party.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class FincoReceiver implements Subject {

    List<ICustomer> customers;
    List<IAccount> accounts;

    public FincoReceiver(){
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void withdraw(){
        // TODO:
    }

    public void deposit(){
        // TODO:
    }

    public void createPerson(){
        // TODO:
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
