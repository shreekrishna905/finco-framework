package com.finco.framework.ui;

import com.finco.framework.party.ICustomer;

public interface CustomerService {
    void create(String accountNumber, ICustomer customer);
}
