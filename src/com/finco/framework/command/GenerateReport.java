package com.finco.framework.command;

import com.finco.framework.FincoReceiver;

public class GenerateReport implements Command{

    private FincoReceiver fincoReceiver;

    private String accountNumber;

    private String type;

    public GenerateReport(FincoReceiver fincoReceiver, String accountNumber, String type){
        this.fincoReceiver = fincoReceiver;
        this.accountNumber = accountNumber;
        this.type=type;
    }

    @Override
    public void execute() {
        fincoReceiver.generateReport(type);
    }
}
