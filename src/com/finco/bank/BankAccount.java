package com.finco.bank;

import com.finco.framework.account.Account;

public class BankAccount extends Account {

    private double interestRate;

    public BankAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate(){
        return interestRate;
    }
}
