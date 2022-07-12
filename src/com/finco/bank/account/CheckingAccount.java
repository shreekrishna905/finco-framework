package com.finco.bank.account;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber) {
        super(accountNumber,8.0/100.0);
    }
}
