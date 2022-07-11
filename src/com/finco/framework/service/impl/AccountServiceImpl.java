package com.finco.framework.service.impl;

import com.finco.framework.Framework;
import com.finco.framework.account.IAccount;
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
    public void addInterest(Double amount) {

    }
}
