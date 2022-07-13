package com.finco.ccard;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.Entry;
import com.finco.framework.account.entry.WithdrawEntry;
import com.finco.framework.party.ICustomer;

import java.time.LocalDate;

public class CcardReceiver extends FincoReceiver {

    public void withdraw(Double amount, IAccount account){
        Entry entry = new WithdrawEntry(LocalDate.now(), amount, "WITHDRAW");
        entry.process(account);
        account.addEntry(entry);
        ICustomer customer = account.getCustomer();
        if( amount>=600){
            customer.sendEmail();
        }
    }

}
