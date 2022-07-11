package com.finco.framework.service;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;
import com.finco.framework.party.ICustomer;

public interface CustomerService {
    void create(IAccount account, ICustomer customer);
}
