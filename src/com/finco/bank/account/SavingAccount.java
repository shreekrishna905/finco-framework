package com.finco.bank.account;

import com.finco.bank.account.BankAccount;

public class SavingAccount extends BankAccount {
    public SavingAccount(String accountNumber) {
        super(accountNumber,10.0/100.0);
    }
}
