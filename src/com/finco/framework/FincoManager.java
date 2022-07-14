package com.finco.framework;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.DepositeEntry;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.account.entry.WithdrawEntry;
import com.finco.framework.observer.Observer;
import com.finco.framework.observer.Subject;
import com.finco.framework.party.ICustomer;
import com.finco.framework.report.FincoReport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FincoManager implements Subject {

    List<ICustomer> customers;
    List<IAccount> accounts;
    List<Observer> observers;
    private FincoReport fincoReport;

    public FincoManager(){
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.observers = new ArrayList<>();
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


    public void createAccount(Account account, ICustomer customer){
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

    public void generateReport(String type){
        String report = fincoReport.generate();
        notifyObserver(report,type);
    }

    public void setReport(FincoReport fincoReport){
        this.fincoReport = fincoReport;
    }

    public List<ICustomer> getCustomers() {
        return customers;
    }

    public List<IAccount> getAccounts() {
        return accounts;
    }

    public IAccount getAccount(String accountNumber){
        for (IAccount account: accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    @Override
    public List<Observer> getObserver() {
        return observers;
    }
}
