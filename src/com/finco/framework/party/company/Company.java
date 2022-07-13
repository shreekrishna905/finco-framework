package com.finco.framework.party.company;

import com.finco.framework.party.Customer;

public class Company extends Customer {

    private int  noOfEmployee;

    public Company(String name, String street, String city, String state, int zip, String email, int noOfEmployee) {
        super(name, street, city, state, zip, email);
        this.noOfEmployee = noOfEmployee;
    }


    @Override
    public void sendEmail() {
        System.out.println("Email send to -> " + this.getEmail());
    }
}
