package com.finco.ccard.account;

public class Bronze implements CcardType{
    
    @Override
    public double getMinimumPayment(){
        return 0.2;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.22;
    }
}
