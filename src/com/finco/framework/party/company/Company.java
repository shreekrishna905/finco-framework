package com.finco.framework.party.company;

import com.finco.framework.party.Customer;
import com.finco.framework.party.person.IPerson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company extends Customer {

    private List<IPerson> employees;

    public Company(String name, String street, String city, String state, int zip, String email) {
        super(name, street, city, state, zip, email);
        this.employees = new ArrayList<>();
    }


    public List<IPerson> getEmployees() {
        return employees;
    }

    public void setEmployees(List<IPerson> employees) {
        this.employees = employees;
    }

    @Override
    public void sendEmail(String email) {
        // TODO: send email
    }
}
