package com.finco.ccard.account;

public class Silver implements CcardType{
    
    @Override
    public double getMinimumPayment(){
        return 0.16;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.18;
    }
}
