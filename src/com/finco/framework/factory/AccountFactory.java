package com.finco.framework.factory;

import com.finco.framework.account.Account;

public abstract class AccountFactory {

        public abstract Account createAccount(String type, String accountNumber);
}
