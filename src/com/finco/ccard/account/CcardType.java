package com.finco.ccard.account;

public interface CcardType {

    double getMinimumPayment();
    double getMonthlyInterest();

    static CcardType getCard(String type){
        if(type.equals("C")){
            return new Copper();
        } else if(type.equals("G")){
            return new Gold();
        } else if(type.equals("S")){
            return new Silver();
        }
        return null;
    }
}
