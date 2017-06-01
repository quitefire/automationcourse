package com.courses.contactList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kate on 31.05.2017.
 */
public class ContactList {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact findByNumber(String phoneNum) {
        if (phoneNum != null) {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                if (phoneNum.equals(contact.getPhoneNum())) {
                    return contact;
                } else {
                    System.out.println(("Контакт з таким номер відутній"));
                }

            }
        } else {
            System.out.println("Номер телефону не зазначений");

        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return Collections.unmodifiableList(contacts);
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Contact c1 = new Contact("Petya", "Qw", "12345");
        Contact c2 = new Contact("Vasya", "Er", "1236");
        contactList.addContact(c1);
        contactList.addContact(c2);

        List<Contact> allContacts = contactList.getAllContacts();
        System.out.println(allContacts);
        String number = "12345";
        contactList.deleteContact(contactList.findByNumber(number));
        System.out.println(allContacts);
    }


}

