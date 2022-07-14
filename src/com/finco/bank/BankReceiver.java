package com.finco.bank;

import com.finco.framework.FincoManager;
import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.DepositeEntry;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.account.entry.WithdrawEntry;
import com.finco.framework.party.ICustomer;

import java.time.LocalDate;

public class BankReceiver extends FincoManager {

    public void deposit(Double amount, IAccount account){
        Entry entry = new DepositeEntry(LocalDate.now(), amount, "DEPOSIT");
        entry.process(account);
        account.addEntry(entry);
        ICustomer customer = account.getCustomer();
        if(account.getCustomer().getClass().getName().equals("Person") && amount>=400){
            customer.sendEmail();
        }

    }

    public void withdraw(Double amount, IAccount account){
        Entry entry = new WithdrawEntry(LocalDate.now(), amount, "WITHDRAW");
        entry.process(account);
        account.addEntry(entry);
        ICustomer customer = account.getCustomer();if(account.getCustomer().getClass().getName().equals("Person") && amount>=400){
            customer.sendEmail();
        }
    }
}
