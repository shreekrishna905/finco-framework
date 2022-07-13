package com.finco.bank;

import com.finco.bank.view.BankView;
import com.finco.framework.FincoReceiver;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.service.AccountService;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.AccountServiceImpl;
import com.finco.framework.service.impl.CustomerServiceImpl;
import com.finco.framework.ui.FinCoView;

public class Bank {

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoReceiver fincoReceiver = new BankReceiver();
        AccountService accountService = new AccountServiceImpl(fincoOperationManager,fincoReceiver);
        CustomerService customerService = new CustomerServiceImpl(fincoOperationManager,fincoReceiver);
        FinCoView finCoView = new BankView(accountService, customerService);
        fincoReceiver.addObserver(finCoView);
        finCoView.setVisible(true);
    }
}
