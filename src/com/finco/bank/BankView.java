package com.finco.bank;

import com.finco.framework.FincoReceiver;
import com.finco.framework.Framework;
import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.factory.AccountFactory;
import com.finco.framework.party.ICustomer;
import com.finco.framework.party.company.Company;
import com.finco.framework.party.person.Person;
import com.finco.framework.service.AccountService;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.AccountServiceImpl;
import com.finco.framework.service.impl.CustomerServiceImpl;
import com.finco.framework.ui.FinCoView;
import com.finco.framework.ui.JDialog_AddCompAcc;
import com.finco.framework.ui.JDialog_AddPAcc;

public class BankView extends FinCoView {

    public BankView(AccountService accountService, CustomerService customerService) {
        super(accountService, customerService);
    }

    public String accountType;

    @Override
    protected JDialog_AddCompAcc getAddCompanyJDialog() {
        return new AddCompanyBankView(this);
    }

    @Override
    protected JDialog_AddPAcc getAddPersonJDialog() {
        return new AddPersonBankView(this);
    }

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoReceiver fincoReceiver = new BankReceiver();
        Framework framework = new Framework(fincoOperationManager, fincoReceiver);
        AccountService accountService = new AccountServiceImpl(framework);
        CustomerService customerService = new CustomerServiceImpl(framework);
        FinCoView finCoView = new BankView(accountService, customerService);
        finCoView.setVisible(true);
    }

    @Override
    protected void createCompany(){
        ICustomer customer = new Company(clientName, street, city, state, Integer.parseInt(zip), email, Integer.parseInt(noOfEmployee));
        AccountFactory bankAccountFactory = AccountFactory.getFactory("bank");
        Account account = bankAccountFactory.createAccount(accountType, accountnr);
        this.customerService.create(account, customer);
    }

    @Override
    protected void createPerson(){
        ICustomer customer = new Person(clientName, street, city, state, Integer.parseInt(zip), email,birthDate);        AccountFactory bankAccountFactory = AccountFactory.getFactory("bank");
        IAccount account = bankAccountFactory.createAccount(accountType, accountnr);
        this.customerService.create(account, customer);
    }
}
