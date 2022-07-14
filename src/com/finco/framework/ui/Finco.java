package com.finco.framework.ui;

import com.finco.framework.FincoManager;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.service.AccountService;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.AccountServiceImpl;
import com.finco.framework.service.impl.CustomerServiceImpl;

public class Finco {

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoManager fincoReceiver = new FincoManager();
        AccountService accountService = new AccountServiceImpl(fincoOperationManager,fincoReceiver);
        CustomerService customerService = new CustomerServiceImpl(fincoOperationManager,fincoReceiver);
        FinCoView finCoView = new FinCoView(accountService, customerService);
        finCoView.setVisible(true);
    }
}
