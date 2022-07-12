package com.finco.ccard.view;

import com.finco.framework.ui.JDialog_AddPAcc;

import javax.swing.*;
import java.awt.*;

public class AddCcardView extends JDialog_AddPAcc {

    JRadioButton JRadioButton_Gold;
    JRadioButton JRadioButton_Silver;
    JRadioButton JRadioButton_Copper;
    CcardView parent = null;
    JLabel Jlabel9 = new JLabel();
    JTextField jTextFieldExpiryDate = new JTextField();
    JLabel JLabel10 = new JLabel();
    JTextField jTextFieldCCNumber = new JTextField();

    public AddCcardView(CcardView parent) {
        super(parent);
        setTitle("Add credit card account");
        setSize(283,400);
        this.parent = parent;
        addAccountType ();
    }

    public void addAccountType (){

        Jlabel9.setText("Expiry");
        getContentPane().add(Jlabel9);
        Jlabel9.setForeground(Color.black);
        Jlabel9.setBounds(12,252,48,24);

        getContentPane().add(jTextFieldExpiryDate);
        jTextFieldExpiryDate.setBounds(84,252,156,20);

        JLabel10.setText("CC No.");
        getContentPane().add(JLabel10);
        JLabel10.setForeground(Color.black);
        JLabel10.setBounds(12,276,48,24);

        getContentPane().add(jTextFieldCCNumber);
        jTextFieldCCNumber.setBounds(84,276,156,20);

        JRadioButton_Gold = new JRadioButton();
        JRadioButton_Silver = new JRadioButton();
        JRadioButton_Copper = new JRadioButton();
        JRadioButton_Gold.setText("Gold");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36,12,84,24);
        JRadioButton_Silver.setText("Silver");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,84,24);
        JRadioButton_Copper.setText("Copper");
        getContentPane().add(JRadioButton_Copper);
        JRadioButton_Copper.setBounds(36,60,84,24);

        JButton_OK.setBounds(48,300,84,24);
        JButton_Cancel.setBounds(156,300,84,24);


    }

    @Override
    protected void accountNumber(){

    }

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        parent.creditCardType =
        parent.accountnr=JTextField_ACNR.getText();
        parent.clientName=JTextField_NAME.getText();
        parent.street=JTextField_STR.getText();
        parent.city=JTextField_CT.getText();
        parent.zip=JTextField_ZIP.getText();
        parent.state=JTextField_ST.getText();
        parent.email=JTextField_EM.getText();
        parent.birthDate=JTextField_BD.getText();
        if (JRadioButton_Gold.isSelected())
            parent.creditCardType="G";
        else if(JRadioButton_Copper.isSelected())
            parent.creditCardType="C";
        else if(JRadioButton_Silver.isSelected())
            parent.creditCardType = "S";
        parent.expiryDate = jTextFieldExpiryDate.getText();
        parent.ccNumber = jTextFieldCCNumber.getText();
        parent.newaccount=true;
        dispose();

    }
}
