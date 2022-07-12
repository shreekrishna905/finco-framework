package com.finco.ccard.account;

public class Gold implements CcardType{

    @Override
    public double getMinimumPayment(){
        return 0.12;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.14;
    }
}
