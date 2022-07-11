package com.finco.framework.account;

import com.finco.framework.account.entry.Entry;

public interface IAccount {
    void addEntry(Entry entry);
    String generateReport();
    String getBalance();
    void deposite();
    void withdraw();
}
