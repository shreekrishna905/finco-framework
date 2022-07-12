package com.finco.bank.factory;

import com.finco.bank.account.CheckingAccount;
import com.finco.bank.account.SavingAccount;
import com.finco.framework.account.Account;
import com.finco.framework.factory.AccountFactory;

public class BankAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(String type, String accountNumber) {
        Account account = null;
        switch(type){
            case "C":
                account = new CheckingAccount(accountNumber);
                break;
            case "S":
                account = new SavingAccount(accountNumber);
                break;
            default:
                account = null;
        }
        return account;
    }
}
