package com.finco.framework.command;

import com.finco.framework.FincoManager;

public class GenerateReport implements Command{

    private FincoManager fincoReceiver;

    private String accountNumber;

    private String type;

    public GenerateReport(FincoManager fincoReceiver, String accountNumber, String type){
        this.fincoReceiver = fincoReceiver;
        this.accountNumber = accountNumber;
        this.type=type;
    }

    @Override
    public void execute() {
        fincoReceiver.generateReport(type);
    }
}
