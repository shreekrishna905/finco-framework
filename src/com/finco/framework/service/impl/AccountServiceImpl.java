package com.finco.framework.service.impl;

import com.finco.framework.Framework;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.*;
import com.finco.framework.report.FincoReport;
import com.finco.framework.report.Top10Deposit;
import com.finco.framework.report.Top10Withdraw;
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
        submitCommand(new Deposit(framework.getFincoReceiver(), amount, account));
    }

    @Override
    public void withdraw(Double amount, IAccount account) {
        submitCommand(new Withdraw(framework.getFincoReceiver(), amount, account));
    }

    @Override
    public void addInterest() {
        submitCommand(new AddInterest(framework.getFincoReceiver()));
    }

    @Override
    public void top10DepositReport(String accountNumber) {
        IAccount account = framework.getFincoReceiver().getAccount(accountNumber);
        framework.getFincoReceiver().setReport(new Top10Deposit(account));
        submitCommand(new GenerateReport(framework.getFincoReceiver(), accountNumber, "TOP_10_DEPOSIT"));
    }

    @Override
    public void top10WithdrawReport(String accountNumber) {
        IAccount account = framework.getFincoReceiver().getAccount(accountNumber);
        framework.getFincoReceiver().setReport(new Top10Deposit(account));
        submitCommand(new GenerateReport(framework.getFincoReceiver(), accountNumber, "TOP_10_WITHDRAW"));
    }

    protected void submitCommand(Command command){
        FincoOperationManager operationManager = framework.getFincoOperationManager();
        operationManager.setCommand(command);
        operationManager.submit();
    }
}
