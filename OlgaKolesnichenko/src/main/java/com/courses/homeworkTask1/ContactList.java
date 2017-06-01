package com.courses.homeworkTask1;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contacts = new ArrayList<>();

    /**
     * @param contact
     * @return
     */
    public boolean addContact(Contact contact) {
        if (contact == null) throw new NullPointerException();
        return contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        contacts.set(findPosition(oldContact), newContact);
    }

    /**
     * @param searchName
     * @return contact matched by name or null if no result found
     */
    public Contact searchByName(String searchName) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(searchName))
                return contact;
        }
        return null;
    }

    public boolean removeContact(Contact contact) {
        return contacts.remove(contact);
    }

    public void removeLastContact() {
        contacts.remove(contacts.size() - 1);
    }

    /**
     * @return first five contacts
     */
    public List<Contact> getFirstFiveContacts() {
        List<Contact> firstFiveContacts = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            firstFiveContacts.add(contacts.get(i));
        }
        return firstFiveContacts;
    }

    /**
     * @return last five contacts
     */
    public List<Contact> getLastFiveContacts() {
        List<Contact> lastFiveContacts = new ArrayList<>();
        for (int i = contacts.size() - 5; i <= contacts.size() - 1; i++) {
            lastFiveContacts.add(contacts.get(i));
        }
        return lastFiveContacts;
    }

    /**
     * @return Life contacts
     */
    public List<Contact> getLifeContacts() {
        List<Contact> lifeContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getNumber().startsWith("093"))
                lifeContacts.add(contacts.get(i));
        }
        return lifeContacts;
    }

    /**
     * @return KievStar contacts
     */
    public List<Contact> getKievStarContacts() {
        List<Contact> kievStarContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getNumber().startsWith("097")) {
                kievStarContacts.add(contacts.get(i));
            }
        }
        return kievStarContacts;
    }

    private int findPosition(Contact contact) {
        return this.contacts.indexOf(contact);
    }
}