package com.finco.framework.factory;

import com.finco.bank.factory.BankAccountFactory;
import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;

public abstract class AccountFactory {

    public abstract Account createAccount(String type, String accountNumber);

    public static AccountFactory getFactory(String type){
        switch (type){
            case "bank":
                return new BankAccountFactory();
            default:
                return null;
        }
    }

}
