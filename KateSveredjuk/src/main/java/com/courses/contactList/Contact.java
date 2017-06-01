package com.courses.contactList;

/**
 * Created by Kate on 31.05.2017.
 */
public class Contact {
    private String name;
    private String lastName;
    private String phoneNum;

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

    public Contact(String name, String lastName, String phoneNum){
        this.name = name;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
    }
}
