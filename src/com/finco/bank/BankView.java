package com.finco.bank;

import com.finco.framework.FincoReceiver;
import com.finco.framework.Framework;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.service.AccountService;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.AccountServiceImpl;
import com.finco.framework.service.impl.CustomerServiceImpl;
import com.finco.framework.ui.FinCoView;
import com.finco.framework.ui.JDialog_AddCompAcc;

public class BankView extends FinCoView {

    public BankView(AccountService accountService, CustomerService customerService) {
        super(accountService, customerService);
    }

    @Override
    protected JDialog_AddCompAcc getAddCompanyJDialog() {
        return new AddAccountView(this);
    }

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoReceiver fincoReceiver = new FincoReceiver();
        Framework framework = new Framework(fincoOperationManager, fincoReceiver);
        AccountService accountService = new AccountServiceImpl(framework);
        CustomerService customerService = new CustomerServiceImpl(framework);
        FinCoView finCoView = new BankView(accountService, customerService);
        finCoView.setVisible(true);
    }
}
