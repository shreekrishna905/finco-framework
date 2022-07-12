package com.finco.framework.party.person;

import com.finco.framework.party.Customer;
import com.finco.framework.party.ICustomer;

public class Person extends Customer implements ICustomer {

    private final String dob;

    public Person(String name, String street, String city, String state, int zip, String email, String dob) {
        super(name, street, city, state, zip, email);
        this.dob = dob;
    }
    public String getDob() {
        return dob;
    }
}
