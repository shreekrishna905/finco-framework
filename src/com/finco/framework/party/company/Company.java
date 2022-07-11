package com.finco.framework.party.company;

import com.finco.framework.account.IAccount;
import com.finco.framework.party.Customer;
import com.finco.framework.party.person.IPerson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company extends Customer {

    private int  noOfEmployee;

    public Company(String name, String street, String city, String state, int zip, String email, int noOfEmployee) {
        super(name, street, city, state, zip, email);
        this.noOfEmployee = noOfEmployee;
    }


    @Override
    public void sendEmail(String email) {
        // TODO: send email
    }


}
