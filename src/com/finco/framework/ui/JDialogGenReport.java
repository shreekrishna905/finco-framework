package com.finco.framework.ui;
/*
		A basic implementation of the JDialog class.
*/

import javax.swing.*;
import java.awt.*;

public class JDialogGenReport extends JDialog {
    String billString;
	JButton okayBt = new JButton();

	public JDialogGenReport(Frame parent, String billString, String title) {
		super(parent);
		this.billString = billString;
		System.out.println("instantiating JDialogGenBill 2");
		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parses  your Java file into its visual envirenment. 
		//{{ INIT_CONTROLS
		setTitle(title);
		getContentPane().setLayout(null);
		setSize(405, 367);
		setVisible(false);


		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 355, 237);

		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scrollPane);
		scrollPane.setBounds(24, 24, 358, 240);

		okayBt.setText("OK");
		okayBt.setActionCommand("OK");
		getContentPane().add(okayBt);
		okayBt.setBounds(156, 276, 96, 24);

		textArea.setText(billString);
		//}}

		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		okayBt.addActionListener(lSymAction);
		//}}
	}

	//{{DECLARE_CONTROLS

	//}}


	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == okayBt)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
			 
	}
}
