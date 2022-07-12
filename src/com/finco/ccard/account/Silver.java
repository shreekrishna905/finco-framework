package com.finco.ccard.account;

public class Silver implements CcardType{
    
    @Override
    public double getMinimumPayment(){
        return 16.0/100.0;
    }

    @Override
    public double getMonthlyInterest() {
        return 18.0/100.0;
    }

    public String toString(){
        return "S";
    }
}
