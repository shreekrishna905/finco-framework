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

    @Override
    public void withdraw(Double amount, String accountNumber) {

    }

    @Override
    public void addInterest(Double amount) {

    }
}
