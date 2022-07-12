package com.finco.framework.service.impl;

import com.finco.framework.Framework;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.AddInterest;
import com.finco.framework.command.FincoOperationManager;
import com.finco.framework.command.GenerateReport;
import com.finco.framework.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private Framework framework;

    public AccountServiceImpl(Framework framework){
        this.framework = framework;
    }

    @Override
    public IAccount findByNo(String number) {
        return null;
    }

    @Override
    public List<IAccount> findAll() {
        return framework.getFincoReceiver().getAccounts();
    }

    public void deposit(Double amount, IAccount account){
        framework.getFincoReceiver().deposit(amount, account);
    }

    @Override
    public void withdraw(Double amount, IAccount account) {
        framework.getFincoReceiver().withdraw(amount,account);
    }

    @Override
    public void addInterest() {
        FincoOperationManager operationManager = framework.getFincoOperationManager();
        operationManager.setCommand(new AddInterest(framework.getFincoReceiver()));
        operationManager.submit();
    }

    @Override
    public void top10DepositReport(String accountNumber) {
        FincoOperationManager operationManager = framework.getFincoOperationManager();
        operationManager.setCommand(new GenerateReport(framework.getFincoReceiver(), accountNumber, "TOP_10_DEPOSIT"));
        operationManager.submit();
    }

    @Override
    public void top10WithdrawReport(String accountNumber) {
        FincoOperationManager operationManager = framework.getFincoOperationManager();
        operationManager.setCommand(new GenerateReport(framework.getFincoReceiver(), accountNumber, "TOP_10_WITHDRAW"));
        operationManager.submit();
    }

}
