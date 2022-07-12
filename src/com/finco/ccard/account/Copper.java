package com.finco.ccard.account;

public class Copper implements CcardType{
    
    @Override
    public double getMinimumPayment(){
        return 20.0/100.0;
    }

    @Override
    public double getMonthlyInterest() {
        return 22.0/100.0;
    }

    public String toString(){
        return "C";
    }
}
