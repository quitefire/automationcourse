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
        // Check if valid number transferred
        checkIfValidPhoneNumber(phone);
        this.phoneNumber = formatNumber(phone);
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        checkIfValidPhoneNumber(phoneNumber);
        this.phoneNumber = formatNumber(phoneNumber);
        return true;
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
