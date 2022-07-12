package com.finco.bank.account;

import com.finco.framework.account.Account;

public class BankAccount extends Account {

    private final double interestRate;

    public BankAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate(){
        return interestRate;
    }
}
