package com.courses.homeworkTask1;

import com.courses.homeworkTask1.Exceptions.InvalidPhoneNumberException;

public class Contact {
    private String name;
    private String number;

    /**
     * @param name
     * @param number
     */
    public Contact(String name, String number) {
        if (number.startsWith("0") && number.matches("[0-9]+") && number.length() == 10) {
            this.name = name;
            this.number = number;
        } else throw new InvalidPhoneNumberException("Invalid number format " + number);
    }

    public void updateContact(String name, String number) {
        if (number.startsWith("0") && number.matches("[0-9]+") && number.length() == 10) {
            this.name = name;
            this.number = number;
        } else throw new InvalidPhoneNumberException("Invalid number format " + number);
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "; Phone: " + getNumber() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Contact) {
            if (this == obj) return true;
            Contact contact = (Contact) obj;
            return this.name.equals(contact.getName())
                    && this.number.equals(contact.getNumber());

        }
        return false;
    }
}