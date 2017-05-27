package com.courses.homeworkTask1;

import java.util.ArrayList;

class ContactList {
    public int contactList;
    public ArrayList< Contact > contacts;

    public ContactList(int contactList) {
        this.contactList = contactList;
        this.contacts = new ArrayList < Contact > ();
    }

    /**
     *
     * @param contact
     */
    public Boolean addContact(Contact contact) {
        if (findPosition(contact) >= 0) {
            System.out.println("Contact already is phone");
            return false;
        } else {
            contacts.add(contact);
        }
        return true;
    }

    public ArrayList < Contact > getContacts() {
        return contacts;
    }

    /**
     *
     * @param oldContact
     * @param newContact
     */
    public void updateContact(Contact oldContact, Contact newContact) {
        if (findPosition(oldContact) >= 0) {
            contacts.set(findPosition(oldContact), newContact);
        } else {
            System.out.println("Contact does not exist");
        }
    }

    /**
     *
     * @param contact
     */
    public void removeContact(Contact contact) {
        if (findPosition(contact) >= 0) {
            contacts.remove(findPosition(contact));
        } else {
            System.out.println("No contact");
        }
    }

    /**
     *
     * @param contact
     */
    public void removeLastContact(Contact contact) {
        if (findPosition(contact) >= 0) {
            contacts.remove(findLastPosition(contact));
        }
        else {
            System.out.println("No contact");
        }
    }

    /**
     *
     * @param contact
     * @return
     */
    public int searchContact(Contact contact) {
        int position = findPosition(contact);
        if (contacts.contains(contact)) {
            System.out.println("Item found at position");
            return position;
        }
        System.out.println("Not found");
        return 1;
    }

    /**
     *
     * @param contact
     * @return
     */
    private int findPosition(Contact contact) {

        return this.contacts.indexOf(contact);
    }

    /**
     *
     * @param contact
     * @return
     */
    private int findLastPosition(Contact contact) {

        return this.contacts.lastIndexOf(contact);
    }

}
