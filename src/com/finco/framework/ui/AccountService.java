package com.finco.framework.ui;

import com.finco.framework.account.Account;

import java.util.List;

public interface AccountService {

    Account findByNo(String number);

    List<Account> findAll();

    void withdraw(Double amount, String accountNumber);

    void addInterest(Double amount);

}
