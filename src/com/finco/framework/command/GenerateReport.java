package com.finco.framework.command;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.report.FincoReport;

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
        IAccount account = fincoReceiver.getAccount(accountNumber);
        fincoReceiver.setReport(FincoReport.getReportType(type, account));
        fincoReceiver.generateReport(type);
    }
}
