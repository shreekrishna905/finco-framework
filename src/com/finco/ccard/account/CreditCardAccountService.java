package com.finco.ccard.account;

import com.finco.ccard.report.CcardReport;
import com.finco.framework.FincoReceiver;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.command.GenerateReport;
import com.finco.framework.service.impl.AccountServiceImpl;

public class CreditCardAccountService extends AccountServiceImpl {

    private FincoReceiver fincoReceiver;

    public CreditCardAccountService(FincoOperationManager fincoOperationManager, FincoReceiver fincoReceiver) {
        super(fincoOperationManager,fincoReceiver);
        this.fincoReceiver = fincoReceiver;
    }

    public void generateMonthlyReport(String accountNumber) {
        CcardAccount account = (CcardAccount) fincoReceiver.getAccount(accountNumber);
        fincoReceiver.setReport(new CcardReport(account));
        submitCommand(new GenerateReport(fincoReceiver, accountNumber, "MONTHLY_REPORT"));
    }

}
