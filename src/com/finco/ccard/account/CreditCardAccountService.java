package com.finco.ccard.account;

import com.finco.ccard.report.CcardReport;
import com.finco.framework.Framework;
import com.finco.framework.command.GenerateReport;
import com.finco.framework.service.impl.AccountServiceImpl;

public class CreditCardAccountService extends AccountServiceImpl {

    private Framework framework;

    public CreditCardAccountService(Framework framework) {
        super(framework);
        this.framework = framework;
    }

    public void generateMonthlyReport(String accountNumber) {
        CcardAccount account = (CcardAccount) framework.getFincoReceiver().getAccount(accountNumber);
        framework.getFincoReceiver().setReport(new CcardReport(account));
        submitCommand(new GenerateReport(framework.getFincoReceiver(), accountNumber, "MONTHLY_REPORT"));
    }

}
