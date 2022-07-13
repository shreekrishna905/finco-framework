package com.finco.ccard;

import com.finco.bank.BankReceiver;
import com.finco.ccard.account.CreditCardAccountService;
import com.finco.ccard.view.CcardView;
import com.finco.framework.FincoReceiver;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.CustomerServiceImpl;
import com.finco.framework.ui.FinCoView;

public class Ccard {

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoReceiver fincoReceiver = new BankReceiver();
        CreditCardAccountService accountService = new CreditCardAccountService(fincoOperationManager,fincoReceiver);
        CustomerService customerService = new CustomerServiceImpl(fincoOperationManager,fincoReceiver);
        FinCoView finCoView = new CcardView(accountService, customerService);
        fincoReceiver.addObserver(finCoView);
        finCoView.setVisible(true);
    }
}
