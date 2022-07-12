package com.finco.ccard.factory;

import com.finco.ccard.account.CcardAccount;
import com.finco.ccard.account.CcardType;
import com.finco.framework.account.Account;
import com.finco.framework.factory.AccountFactory;

public class CcardAcountFactory{
    public Account createAccount(String accountNumber, String creditCardNumber, String expDate, String ccv, double creditLimit, CcardType type, double monthlyInterest, double minimumPayment, double creditUse) {
        return new CcardAccount(accountNumber, creditCardNumber, expDate, ccv, creditLimit, type, monthlyInterest, minimumPayment, creditUse);
    }
}
