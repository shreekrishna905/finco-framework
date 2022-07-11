package com.finco.framework.command;

import com.finco.framework.FincoReceiver;
import com.finco.framework.party.ICustomer;

public class CreateAccount implements Command {

    private String accountNumber;

    private ICustomer customer;

    private FincoReceiver fincoReceiver;

    public CreateAccount(FincoReceiver fincoReceiver, String accountNumber, ICustomer iCustomer){
        this.fincoReceiver = fincoReceiver;
        this.accountNumber = accountNumber;
        this.customer = iCustomer;
    }

    @Override
    public void execute() {
        fincoReceiver.createCompany(accountNumber, customer);
    }


}
