package com.finco.ccard.view;

import com.finco.bank.BankReceiver;
import com.finco.ccard.account.CcardAccount;
import com.finco.ccard.account.CcardType;
import com.finco.ccard.account.CreditCardAccountService;
import com.finco.framework.FincoReceiver;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.party.ICustomer;
import com.finco.framework.party.person.Person;
import com.finco.framework.service.CustomerService;
import com.finco.framework.service.impl.CustomerServiceImpl;
import com.finco.framework.ui.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class CcardView extends FinCoView {

    private CreditCardAccountService creditCardAccountService;

    public CcardView(CreditCardAccountService accountService, CustomerService customerService) {
        super(accountService, customerService);
        this.creditCardAccountService = accountService;
        setSize(650, 400);
        JButton_Withdraw.setText("Charge");
        JButton_Deposit.setText("Pay");
        setTitle("Credit Card Application");

    }

    protected String creditCardType;

    protected String ccNumber;

    protected String expiryDate;


    @Override
    protected JDialog_AddPAcc getAddPersonJDialog(){
        return new AddCcardView(this);
    }

    @Override
    protected void addButtons(){
        JButton_PerAC.setText("Add Ccard Account");
        JButton_CompAC.setText("Generate Monthly Bill");

    }

    @Override
    public List<String> getTableColumnNames(){
        return List.of("Name", "CC Number", "Expiry Date", "Type",  "Balance");
    }


    public void loadAccountData(Collection<IAccount> accounts, DefaultTableModel model, JTable table) {
        model.setRowCount(0);

        for (IAccount account : accounts) {
            CcardAccount c = (CcardAccount) account;
                    Object[] row = new Object[8];
            row[0] = c.getAccountNumber();
            row[1] = c.getCustomer().getName();
            row[2] = c.getExpDate();
            row[3] = c.getType().toString();
            row[4] = c.getCurrentBalance();
            model.addRow(row);
        }

        table.getSelectionModel().setAnchorSelectionIndex(-1);
        newaccount = false;
    }

    public static void main(String[] args) {
        FincoOperationManager fincoOperationManager = new FincoOperationManager();
        FincoReceiver fincoReceiver = new BankReceiver();
        CreditCardAccountService accountService = new CreditCardAccountService(fincoOperationManager,fincoReceiver);
        CustomerService customerService = new CustomerServiceImpl(fincoOperationManager,fincoReceiver);
        FinCoView finCoView = new CcardView(accountService, customerService);
        fincoReceiver.addObserver(finCoView);
        finCoView.setVisible(true);
    }

    @Override
    protected void createPerson(){
        ICustomer customer = new Person(clientName, street, city, state, Integer.parseInt(zip), email,birthDate);
        CcardAccount ccardAccount = new CcardAccount(ccNumber, LocalDate.parse(expiryDate), CcardType.getCard(creditCardType));
        this.customerService.create(ccardAccount, customer);
    }

    public void JButtonCompAC_actionPerformed(ActionEvent event) {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection < 0) {
            JOptionPane.showMessageDialog(JButton_Top10Withdraw, "Please send an account",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String accnr = (String) model.getValueAt(selection, 0);
        creditCardAccountService.generateMonthlyReport(accnr);
    }


    public void JButtonDeposit_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            // Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            double deposit = Double.parseDouble(amountDeposit);

            List<IAccount> accounts = this.accountService.findAll();

            IAccount acc = accounts.stream()
                    .filter(x -> x.getAccountNumber() .equals(model.getValueAt(selection, 0))).findFirst().get();

            accountService.withdraw(deposit, acc);
            model.setValueAt(String.valueOf(acc.getCurrentBalance()), selection, 4);
        } else {
            JOptionPane.showMessageDialog(JButton_Addinterest, "Please first select an account to deposit to.",
                    "Deposit", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void JButtonWithdraw_actionPerformed(ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            // Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            double withdrawAmount = Double.parseDouble(amountDeposit);

            List<IAccount> accounts = this.accountService.findAll();

            IAccount acc = accounts.stream()
                    .filter(x -> x.getAccountNumber() .equals(model.getValueAt(selection, 0))).findFirst().get();

            accountService.deposit(withdrawAmount, acc);
            model.setValueAt(String.valueOf(acc.getCurrentBalance()), selection, 4);
        } else {

        }
    }

    @Override
    public void update(String data, String type) {
        if(type.equals("MONTHLY_REPORT")){
            JDialogGenReport billFrm = new JDialogGenReport(this, data, "Monthly Report");
            billFrm.setBounds(450, 20, 400, 350);
            billFrm.show();
        }
    }

    protected void addButtonsActionListener(SymAction symAction){
        JButton_Top10Deposit.addActionListener(symAction);
        JButton_Top10Withdraw.addActionListener(symAction);
    }

}
