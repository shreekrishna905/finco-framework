package com.finco.ccard.account;

import com.finco.framework.account.Account;

import java.time.LocalDate;

public class CcardAccount extends Account {

    private LocalDate expDate;
    private String ccv;
    private double creditLimit;
    private double creditUse;
    private CcardType type;

    public CcardAccount(String creditCardNumber, LocalDate expDate, CcardType ccardType){
        super(creditCardNumber);
        this.expDate = expDate;
        this.type = ccardType;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getCcv() {
        return ccv;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public CcardType getType() {
        return type;
    }

    public void setType(CcardType type) {
        this.type = type;
    }

    public double getCreditUse() {
        return creditUse;
    }

    public double getInterestRate(){
        return type.getMonthlyInterest();
    }
}
