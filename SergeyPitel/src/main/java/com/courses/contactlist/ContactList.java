package com.courses.contactlist;


import java.util.ArrayList;
import java.util.List;

import com.courses.contactlist.exceptions.InvalidPhoneNumberException;

import static com.courses.contactlist.utils.PhoneNumberValidator.*;

public class ContactList {

    private List<Contact> contacts = new ArrayList<>();

    /**
     * Appends new contact to the end of this list.
     *
     * @return true if contact successfully added
     * @throws NullPointerException        if the specified contact is null
     * @throws InvalidPhoneNumberException if contact phone number is invalid
     */
    public boolean addNewContact(Contact contact) {
        if (contact == null) throw new NullPointerException();
        return contacts.add(contact);
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     *
     * @param contact element to be removed if present
     * @return true if this list contained the specified element
     * @throws InvalidPhoneNumberException if contact phone number is invalid
     */
    public boolean removeContact(Contact contact) {
        return contacts.remove(contact);
    }


    /**
     * Search contacts that equals to search contact
     *
     * @param contact is contact to search
     * @return Contact object that equals to search object
     */
    public Contact findContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.equals(contact)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Search contacts that contains specified numbers
     *
     * @param phoneNumber is search number
     * @return List of contacts that matched search query
     */
    public List<Contact> findContactsByPhoneNumber(String phoneNumber) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getPhoneNumber().contains(phoneNumber)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Search contacts that starts with specified name
     *
     * @param name is contact name to search
     * @return List of contacts that matched search query
     */
    public List<Contact> findContactsByName(String name) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().startsWith(name)) {
                result.add(c);
            }
        }
        return result;
    }

    public void showAllContacts() {
        System.out.println(contacts.toString());
    }

    public void showFirstFiveContacts() {
        int amount = 5;
        amount = amount > contacts.size() ? contacts.size() : amount;
        System.out.println(contacts.subList(0, amount));
    }

    public void showLastFiveContacts() {
        int amount = 5;
        amount = amount > contacts.size() ? contacts.size() - contacts.size() : contacts.size() - amount;
        System.out.println(contacts.subList(amount, contacts.size()));
    }

    public List<Contact> getLifeContacts() {
        List<Contact> lifeList = new ArrayList<>();
        for (Contact c : contacts) {
            for (String prefix : LIFE_PREFIXES) {
                if (c.getPhoneNumber().startsWith(prefix)) {
                    lifeList.add(c);
                }
            }
        }
        return lifeList;
    }

    public List<Contact> getKiyvstarContacts() {
        List<Contact> kiyvstarList = new ArrayList<>();
        for (Contact c : contacts) {
            for (String prefix : KIYVSTAR_PREFIXES) {
                if (c.getPhoneNumber().startsWith(prefix)) {
                    kiyvstarList.add(c);
                }
            }
        }
        return kiyvstarList;
    }
}
