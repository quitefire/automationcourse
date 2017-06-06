package com.courses.contactList;

import java.util.List;

/**
 * Created by Kate on 06.06.2017
 */
public class ContactListMain {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Contact c1 = null;
        Contact c2 = null;
        try {
            c1 = new Contact("Petya", "Qw", "123456789012");
            c2 = new Contact("Vasya", "Er", "1236");
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to create contact");
        }

        contactList.addContact(c1);
        contactList.addContact(c2);

        List<Contact> allContacts = contactList.getAllContacts();
        System.out.println(allContacts);
        String number = "12345";
        contactList.deleteContact(contactList.findByNumber(number));
        System.out.println(allContacts);
    }
}

