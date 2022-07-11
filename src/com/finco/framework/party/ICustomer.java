package com.finco.framework.party;

import com.finco.framework.account.Account;
import com.finco.framework.account.IAccount;

import java.util.List;

public interface ICustomer {
    void sendEmail(String email);
    void addAccount(IAccount account);
    String getName();
    String getStreet();
    String getCity();
    String getState();
    List<IAccount> getAccount();
    int getZip();
    String getEmail();
}
