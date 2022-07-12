package com.finco.framework.report;

import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.Entry;

public class Top10Deposit implements FincoReport{

    private IAccount account;

    public Top10Deposit(IAccount account){
        this.account = account;
    }

    @Override
    public String generate() {
        String deposit = "";
        for (Entry entry: account.getEntries()){
            if(entry.getName().equals("DEPOSIT")){
                deposit+="Date:"+ entry.getDate()+" Amount:"+entry.getAmount()+"\n";
            }
        }
        return deposit;
    }
}
