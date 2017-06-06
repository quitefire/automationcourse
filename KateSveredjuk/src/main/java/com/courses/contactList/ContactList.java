package com.courses.contactList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kate on 31.05.2017.
 */
public class ContactList {

    private List<Contact> contacts = new ArrayList<>();

    public boolean addContact(Contact contact) {
        if (contact == null) {
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean deleteContact(Contact contact) {
        return contacts.remove(contact);
    }

    public Contact findByNumber(String phoneNum) {
        if (phoneNum != null) {
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                if (phoneNum.equals(contact.getPhoneNum())) {
                    return contact;
                } else {
                    System.out.println(("Контакт з таким номер відутній: " + phoneNum));
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
}

