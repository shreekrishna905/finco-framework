package com.finco.framework.party;

import com.finco.framework.account.IAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements ICustomer {
    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;

    private List<IAccount> account;

    protected Customer(String name, String street, String city, String state, int zip, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.account = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IAccount> getAccount() {
        return account;
    }

    public void setAccount(List<IAccount> account) {
        this.account = account;
    }
}
