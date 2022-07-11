package com.finco.bank;

import com.finco.framework.ui.FinCoView;
import com.finco.framework.ui.JDialog_AddCompAcc;

import javax.swing.*;

public class AddAccountView extends JDialog_AddCompAcc {

    JRadioButton JRadioButton_Chk;
    JRadioButton JRadioButton_Sav;
    FinCoView parent = null;

    public AddAccountView(BankView parent) {
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
        parent.noOfEmployee = JTextField_NoOfEmp.getText();

       if (JRadioButton_Chk.isSelected())
           parent.accountType="Ch";
          else
              parent.accountType="S";
        parent.newaccount=true;
        dispose();

    }


}
