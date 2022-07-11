package com.finco.framework.command;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.party.ICustomer;

public class CreateAccount implements Command {

    private IAccount account;

    private ICustomer customer;

    private FincoReceiver fincoReceiver;

    public CreateAccount(FincoReceiver fincoReceiver, IAccount account, ICustomer iCustomer){
        this.fincoReceiver = fincoReceiver;
        this.account = account;
        this.customer = iCustomer;
    }

    @Override
    public void execute() {
        fincoReceiver.createAccount(account, customer);
    }


}
