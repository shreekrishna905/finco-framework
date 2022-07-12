package com.finco.framework.report;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;

public interface FincoReport {
    String generate();

    static FincoReport getReportType(String type, IAccount account){
        if(type.equals("TOP_10_DEPOSIT")){
            return new Top10Deposit(account);
        } else if(type.equals("TOP_10_WITHDRAW")){
            return new Top10Withdraw(account);
        }
        return null;
    }
}
