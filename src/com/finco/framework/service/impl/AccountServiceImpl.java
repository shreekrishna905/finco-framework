package com.finco.framework.service.impl;

import com.finco.framework.FincoReceiver;
import com.finco.framework.account.IAccount;
import com.finco.framework.command.*;
import com.finco.framework.report.Top10Deposit;
import com.finco.framework.report.Top10Withdraw;
import com.finco.framework.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private FincoOperationManager fincoOperationManager;

    private FincoReceiver fincoReceiver;

    public AccountServiceImpl(FincoOperationManager fincoOperationManager, FincoReceiver fincoReceiver){
        this.fincoOperationManager = fincoOperationManager;
        this.fincoReceiver = fincoReceiver;
    }

    @Override
    public IAccount findByNo(String number) {
        return null;
    }

    @Override
    public List<IAccount> findAll() {
        return fincoReceiver.getAccounts();
    }

    public void deposit(Double amount, IAccount account){
        submitCommand(new Deposit(fincoReceiver, amount, account));
    }

    @Override
    public void withdraw(Double amount, IAccount account) {
        submitCommand(new Withdraw(fincoReceiver, amount, account));
    }

    @Override
    public void addInterest() {
        submitCommand(new AddInterest(fincoReceiver));
    }

    @Override
    public void top10DepositReport(String accountNumber) {
        IAccount account = fincoReceiver.getAccount(accountNumber);
        fincoReceiver.setReport(new Top10Deposit(account));
        submitCommand(new GenerateReport(fincoReceiver, accountNumber, "TOP_10_DEPOSIT"));
    }

    @Override
    public void top10WithdrawReport(String accountNumber) {
        IAccount account = fincoReceiver.getAccount(accountNumber);
        fincoReceiver.setReport(new Top10Withdraw(account));
        submitCommand(new GenerateReport(fincoReceiver, accountNumber, "TOP_10_WITHDRAW"));
    }

    protected void submitCommand(Command command){
        fincoOperationManager.setCommand(command);
        fincoOperationManager.submit();
    }
}
