package com.finco.framework.service;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;

import java.util.List;

public interface AccountService {

    IAccount findByNo(String number);

    List<IAccount> findAll();

    void deposit(Double amount, IAccount account);

    void withdraw(Double amount, IAccount account);

    void addInterest();

    void top10DepositReport(String accoutNumber);
    void top10WithdrawReport(String accoutNumber);

}
