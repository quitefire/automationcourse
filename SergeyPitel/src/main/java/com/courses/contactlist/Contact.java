package com.courses.contactlist;


import com.courses.contactlist.exceptions.InvalidPhoneNumberException;

import static com.courses.contactlist.utils.PhoneNumberValidator.checkIfValidPhoneNumber;
import static com.courses.contactlist.utils.PhoneNumberValidator.formatNumber;


public class Contact {

    private String name;
    private String phoneNumber;

    /**
     * Constructs contact object.
     *
     * @param name  is a contact name
     * @param phone is phone number
     * @throws InvalidPhoneNumberException if contact phone number is invalid
     */
    public Contact(String name, String phone) {
        this.name = name;
        setPhoneNumber(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        checkIfValidPhoneNumber(phoneNumber);
        this.phoneNumber = formatNumber(phoneNumber);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + "\n";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Contact) {
            if (this == obj) return true;

            Contact contact = (Contact) obj;
            return this.name.equals(contact.getName())
                    && this.phoneNumber.equals(contact.getPhoneNumber());

        }
        return false;
    }
}
