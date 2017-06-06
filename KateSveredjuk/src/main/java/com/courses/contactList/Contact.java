package com.courses.contactList;

/**
 * Created by Kate on 31.05.2017
 */
public class Contact {
    private String name;
    private String lastName;
    private String phoneNum;

    public Contact(String name, String lastName, String phoneNum){
        if (name == null){
            throw new IllegalArgumentException("The name is null");
        }
        if (lastName == null){
            throw new IllegalArgumentException("The lastname is null");
        }
        if (!phoneNum.matches("^\\+?[0-9]{12}$")){
            throw new IllegalArgumentException("Incorrect phone number");
        }
        this.name = name;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return phoneNum != null ? phoneNum.equals(contact.phoneNum) : contact.phoneNum == null;
    }

    @Override
    public int hashCode() {
        return phoneNum != null ? phoneNum.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


}
