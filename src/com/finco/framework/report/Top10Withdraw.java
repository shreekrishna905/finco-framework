package com.finco.framework.report;

import com.finco.framework.account.IAccount;
import com.finco.framework.account.entry.Entry;

public class Top10Withdraw implements FincoReport{
    private IAccount account;

    public Top10Withdraw(IAccount account){
        this.account = account;
    }

    @Override
    public String generate() {
        String withdraw = "";
        for (Entry entry: account.getEntries()){
            if(entry.getName().equals("WITHDRAW")){
                withdraw+="Date:"+ entry.getDate()+" Amount:"+entry.getAmount()+"\n";
            }
        }
        return withdraw;
    }
}
