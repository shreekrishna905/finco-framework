package com.finco.framework;

import com.finco.framework.account.IAccount;
import com.finco.framework.observer.Observer;
import com.finco.framework.observer.Subject;
import com.finco.framework.party.ICustomer;

import java.util.List;

public class FincoReceiver implements Subject {

    List<ICustomer> customerList;
    List<IAccount> accountList;

    public void withdraw(){
        // TODO:
    }

    public void deposit(){
        // TODO:
    }

    public void createPerson(){
        // TODO:
    }

    public void createCompany(){
        // TODO:
    }

    public void createAccount(){
        // TODO:
    }

    public void generateReport(){
        // TODO:
    }

    public void setReport(){
        // TODO:
    }

    // MARK:- Subject function

    @Override
    public void addObserver(Observer observer) {
        // TODO:
    }

    @Override
    public void removeObserver(Observer observer) {
        // TODO:
    }

    @Override
    public void notifyObserver() {
        // TODO:
    }
}
