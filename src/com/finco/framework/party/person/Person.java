package com.finco.framework.party.person;

import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

import java.util.Date;

public class Person extends Customer implements ICustomer {

    private final Date dob;

    public Person(String name, String street, String city, String state, int zip, String email, Date dob) {
        super(name, street, city, state, zip, email);
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public void sendEmail() {
        System.out.println("Email send to -> " + this.getEmail());
    }
}
