package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;
import com.finco.framework.party.Customer;

public interface IAccount {
    void addEntry(Entry entry);
    String generateReport();
    String getBalance();
    void deposite();
    void withdraw();

    String getAccountNumber();

    Customer getCustomer();

    String getCurrentBalance();
}
