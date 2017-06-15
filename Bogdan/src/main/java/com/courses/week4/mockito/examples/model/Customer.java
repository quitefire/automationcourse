package com.courses.week4.mockito.examples.model;

import com.courses.week4.mockito.examples.enums.Gender;

public class Customer {

    private String firstName;
    private String lastName;
    private Address homeAddress;
    private Address workAddress;
    private String phone;
    private Gender gender;

    public Customer(String firstName, String lastName, Address homeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
