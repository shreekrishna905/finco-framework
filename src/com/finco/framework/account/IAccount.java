package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;
import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

import java.util.List;

public interface IAccount {


    void addEntry(Entry entry);
     String generateReport();
     String getBalance();
     void deposit(double amount);
     void withdraw(double amount);

     String getAccountNumber();
     ICustomer getCustomer();

     List<Entry> getEntries();

     default String getAccountType(){return "";}

    default double getInterestRate(){ return 0.0; };

    double getCurrentBalance();

}
