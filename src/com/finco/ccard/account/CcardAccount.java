package com.finco.ccard.account;

import com.finco.framework.account.Account;

public class CcardAccount extends Account {

    private String creditCardNumber;
    private String expDate;
    private String ccv;
    private double creditLimit;
    private CcardType type;
    private double monthlyInterest;
    private double minimumPayment;
    private double creditUse;

    public CcardAccount(String accountNumber, String creditCardNumber, String expDate, String ccv, double creditLimit, CcardType type, double monthlyInterest, double minimumPayment, double creditUse) {
        super(accountNumber);
        this.creditCardNumber = creditCardNumber;
        this.expDate = expDate;
        this.ccv = ccv;
        this.creditLimit = creditLimit;
        this.type = type;
        this.monthlyInterest = monthlyInterest;
        this.minimumPayment = minimumPayment;
        this.creditUse = creditUse;
    }
}
