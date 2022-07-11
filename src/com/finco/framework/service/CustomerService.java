package com.finco.framework.service;

import com.finco.framework.party.ICustomer;

public interface CustomerService {
    void create(String accountNumber, ICustomer customer);
}
