package com.courses.homeworkTask1;

import java.util.ArrayList;

class ContactList {
    public int contactList;
    public ArrayList < Contact > contacts;

    public ContactList(int contactList) {
        this.contactList = contactList;
        this.contacts = new ArrayList < Contact > ();
    }

    public void addContact(Contact contact) {
            contacts.add(contact);
    }

    public ArrayList < Contact > getContacts() {
        return contacts;
    }

    public void updateContact(Contact oldContact, Contact newContact) {
            contacts.set(findPosition(oldContact), newContact);
    }

    public void removeContact(Contact contact) {
            contacts.remove(findPosition(contact));
    }

    public void removeLastContact(Contact contact) {
            contacts.remove(findLastPosition(contact));
    }

    public ArrayList <Contact> getFirstFiveContacts(){
        ArrayList <Contact> firstFiveContacts = new ArrayList<>();
        for (int i = 0; i <= 4 ; i++ ){
            firstFiveContacts.add(contacts.get(i));
        }
        return firstFiveContacts;
    }

    public ArrayList <Contact> getLastFiveContacts(){
        ArrayList <Contact> lastFiveContacts = new ArrayList<>();
        for (int i = contacts.size()-5; i <= contacts.size()-1 ; i++ ){
            lastFiveContacts.add(contacts.get(i));
        }
        return lastFiveContacts;
    }

    private int findPosition(Contact contact) {
        return this.contacts.indexOf(contact);
    }
    private int findLastPosition(Contact contact) {
        return this.contacts.lastIndexOf(contact);
    }

}
