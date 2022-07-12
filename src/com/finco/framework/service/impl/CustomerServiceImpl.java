package com.finco.framework.service.impl;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.Account;
import com.finco.framework.command.CreateAccount;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.party.ICustomer;
import com.finco.framework.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private FincoOperationManager fincoOperationManager;

    private FincoReceiver fincoReceiver;

    public CustomerServiceImpl(FincoOperationManager fincoOperationManager, FincoReceiver fincoReceiver){
        this.fincoOperationManager = fincoOperationManager;
        this.fincoReceiver = fincoReceiver;
    }

    @Override
    public void create(Account account, ICustomer customer) {
        fincoOperationManager.setCommand(new CreateAccount(fincoReceiver,account,customer));
        fincoOperationManager.submit();
    }

}
