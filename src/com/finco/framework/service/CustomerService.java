package com.finco.framework.service;

import com.finco.framework.account.Account;
import com.finco.framework.party.ICustomer;

public interface CustomerService {
    void create(Account account, ICustomer customer);
}
