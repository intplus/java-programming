package com.alex;

public class Customer {
    private String name;
    private String surname;
    private String phone;

    public Customer(String name, String surname, String phone) {
        this.name = name;
        this.phone = phone;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}