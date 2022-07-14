package com.finco.framework.command;

import com.finco.framework.FincoManager;
import com.finco.framework.account.Account;
import com.finco.framework.party.ICustomer;

public class CreateAccount implements Command {

    private Account account;

    private ICustomer customer;

    private FincoManager fincoReceiver;

    public CreateAccount(FincoManager fincoReceiver, Account account, ICustomer iCustomer){
        this.fincoReceiver = fincoReceiver;
        this.account = account;
        this.customer = iCustomer;
    }

    @Override
    public void execute() {
        fincoReceiver.createAccount(account, customer);
    }


}
