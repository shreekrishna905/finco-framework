package com.finco.framework.service.impl;

import com.finco.framework.Framework;
import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.CreateAccount;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.party.ICustomer;
import com.finco.framework.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private Framework framework;

    public CustomerServiceImpl(Framework framework){
        this.framework = framework;
    }

    @Override
    public void create(Account account, ICustomer customer) {
        FincoOperationManager operationManager = framework.getFincoOperationManager();
        operationManager.setCommand(new CreateAccount(framework.getFincoReceiver(),account,customer));
        operationManager.submit();
    }

}
