package com.finco.bank.view;

import com.finco.bank.BankReceiver;
import com.finco.framework.FincoReceiver;
import com.finco.framework.Framework;
import com.finco.framework.account.Account;
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
import com.finco.framework.ui.JDialogGenReport;
import com.finco.framework.ui.JDialog_AddCompAcc;
import com.finco.framework.ui.JDialog_AddPAcc;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BankView extends FinCoView {

    public BankView(AccountService accountService, CustomerService customerService) {
        super(accountService, customerService);
        setSize(650, 350);
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
        fincoReceiver.addObserver(finCoView);
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
        Account account = bankAccountFactory.createAccount(accountType, accountnr);
        this.customerService.create(account, customer);
    }

    protected void addButtons(){
        JButton_Deposit.setBounds(468, 90, 150, 33);
        JButton_Withdraw.setBounds(468, 140, 150, 33);
        JButton_Top10Deposit.setText("Top 10 Deposit");
        JPanel1.add(JButton_Top10Deposit);
        JButton_Top10Deposit.setBounds(468, 190, 150, 33);

        JButton_Top10Withdraw.setText("Top 10 Withdraw");
        JPanel1.add(JButton_Top10Withdraw);
        JButton_Top10Withdraw.setBounds(468, 240, 150, 33);
    }

    protected void addButtonsActionListener(SymAction symAction){
        JButton_Top10Deposit.addActionListener(symAction);
        JButton_Top10Withdraw.addActionListener(symAction);
    }


    protected void actionPerformedButtons(ActionEvent event){
        Object object = event.getSource();
        if (object == JButton_Top10Deposit)
            JButtonTop10Deposit_actionPerformed(event);
        else if (object==JButton_Top10Withdraw)
            JButtonTop10Withdraw_actionPerformed(event);


    }

    void JButtonTop10Withdraw_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection < 0) {
            JOptionPane.showMessageDialog(JButton_Top10Withdraw, "Please send an account",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String accnr = (String) model.getValueAt(selection, 0);
        accountService.top10WithdrawReport(accnr);

    }

    void JButtonTop10Deposit_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection < 0) {
            JOptionPane.showMessageDialog(JButton_Top10Withdraw, "Please send an account",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String accnr = (String) model.getValueAt(selection, 0);
        accountService.top10DepositReport(accnr);
    }

    @Override
    public void update(String data, String type) {
        if(type.equals("TOP_10_DEPOSIT")){
            JDialogGenReport billFrm = new JDialogGenReport(this, data, "Top 10 deposit");
            billFrm.setBounds(450, 20, 400, 350);
            billFrm.show();
        } else if(type.equals("TOP_10_WITHDRAW")){
            JDialogGenReport billFrm = new JDialogGenReport(this, data, "Top 10 withdraw");
            billFrm.setBounds(450, 20, 400, 350);
            billFrm.show();
        }
    }
}
