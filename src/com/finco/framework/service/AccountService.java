package com.finco.framework.service;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;

import java.util.List;

public interface AccountService {

    IAccount findByNo(String number);

    List<IAccount> findAll();

    void withdraw(Double amount, String accountNumber);

    void addInterest(Double amount);

}
