package com.courses.contactlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class ContactList {

    public List<Contact> contacts = new ArrayList<>();


    void addContact(Contact person) {
        contacts.add(person);
    }

    boolean removeLast() {
        return !contacts.isEmpty() && contacts.remove(contacts.get(contacts.size() - 1));
    }

    public Contact findContact(Contact person) {

        for (Contact item : contacts) {

            if (person.equals(item)) {
                System.out.println("Contact found");
                return item;
            }
        }
        return null;
    }

    public boolean removeContact(Contact person) {
        for (Contact item : contacts) {
            if (person.equals(item)) {
                return contacts.remove(item);
            }
        }
        return false;
    }

    public void updateContactInfo(Contact person, String name) {

        for (Contact item : contacts) {

            if (person.equals(item)) {
                item.setName(name);
            }
        }
    }

    public void showAllContacts() {
        System.out.println(contacts);

    }

    public void showFirstFiveContacts() {
        //check if contacts.size less than 5 set size to contacts.size
        int size = contacts.size() < 5 ? contacts.size() : 5 ;
        for (int i = 0; i < size; i++) {
            System.out.println(contacts.get(i));
        }
    }

    public void showLastFiveContacts() {
        int size = Math.max(contacts.size() - 5, 0);
        //int size = contacts.size() < 5 ? contacts.size() - contacts.size()  : contacts.size()-5 ;
        System.out.println(contacts.subList(size,contacts.size()));

    }

    public static boolean numberValidation(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) {
            return true;
        } else {
            throw new IllegalArgumentException("Phone is not valid");
        }
    }

    public static boolean nameValidation(String name) {
        if (name.matches("^[a-zA-z ]*$")) {
            return true;
        } else {
            throw new IllegalArgumentException("Name is not valid");
        }
    }

    public void showLifeContacts() {
        String[] lifeCode = {"063", "073"};
        for (Contact item : contacts) {
            if (item.getNumber().contains(lifeCode[0]) || item.getNumber().contains(lifeCode[1])) {
                System.out.println(item.getName() + " " + item.getNumber());
            }
        }

    }

    void showKiyvstarContacts() {
        String[] kievStarCode = {"067", "097"};
        for (Contact item : contacts) {
            if (item.getNumber().contains(kievStarCode[0]) || item.getNumber().contains(kievStarCode[1])) {
                System.out.println(item.getName() + " " + item.getNumber());
            }
        }
    }
}
