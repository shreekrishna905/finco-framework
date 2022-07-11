package com.finco.bank;

import com.finco.framework.ui.JDialog_AddPAcc;

import javax.swing.*;

public class AddPersonBankView extends JDialog_AddPAcc {

    JRadioButton JRadioButton_Chk;
    JRadioButton JRadioButton_Sav;
    BankView parent = null;

    public AddPersonBankView(BankView parent) {
        super(parent);
        this.parent = parent;
        addAccountType ();
    }

    public void addAccountType (){
        JRadioButton_Chk = new JRadioButton();
        JRadioButton_Sav = new JRadioButton();
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36,12,84,24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);
    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        parent.accountnr=JTextField_ACNR.getText();
        parent.clientName=JTextField_NAME.getText();
        parent.street=JTextField_STR.getText();
        parent.city=JTextField_CT.getText();
        parent.zip=JTextField_ZIP.getText();
        parent.state=JTextField_ST.getText();
        parent.email=JTextField_EM.getText();
        parent.birthDate=JTextField_BD.getText();
        if (JRadioButton_Chk.isSelected())
            parent.accountType="C";
        else
            parent.accountType="S";
        parent.newaccount=true;
        dispose();

    }
}
