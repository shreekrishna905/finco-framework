package com.finco.ccard.account;

public class Gold implements CcardType{

    @Override
    public double getMinimumPayment(){
        return 12.0/100.0;
    }

    @Override
    public double getMonthlyInterest() {
        return 14.0/100.0;
    }

    public String toString(){
        return "G";
    }
}
