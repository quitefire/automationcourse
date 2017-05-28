package com.courses.homeworkTask1;

import java.util.ArrayList;

class ContactList {
    public int contactList;
    public ArrayList < Contact > contacts;

    public ContactList(int contactList) {
        this.contactList = contactList;
        this.contacts = new ArrayList < Contact > ();
    }

    public Boolean addContact(Contact contact) {
            contacts.add(contact);
        return true;
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

    /**
     *
     * @param number
     * @return
     */
    public Boolean isValidPhone(String number) {
        if (!(number.contains("0") || number.contains("1") | number.contains("2") | number.contains("3") | number.contains("4") | number.contains("5") | number.contains("6") | number.contains("7") | number.contains("8") | number.contains("9")) || number.length() != 10) {
            System.out.println("Contact is not added!\n" +
                    "Phone number should contain 10 numbers. Try again..");
            return false;
        } else return true;
    }

    /**
     *
     * @return first five contacts
     */
    public ArrayList <Contact> getFirstFiveContacts(){
        ArrayList <Contact> firstFiveContacts = new ArrayList<>();
        for (int i = 0; i <= 4 ; i++ ){
            firstFiveContacts.add(contacts.get(i));
        }
        return firstFiveContacts;
    }

    /**
     *
     * @return last five contacts
     */
    public ArrayList <Contact> getLastFiveContacts(){
        ArrayList <Contact> lastFiveContacts = new ArrayList<>();
        for (int i = contacts.size()-5; i <= contacts.size()-1 ; i++ ){
            lastFiveContacts.add(contacts.get(i));
        }
        return lastFiveContacts;
    }

    /**
     *
     * @return Life contacts
     */
    public ArrayList <Contact> getLifeContacts(){
        ArrayList <Contact> lifeContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++ ){
            if(contacts.get(i).getNumber().startsWith("093"))
                lifeContacts.add(contacts.get(i));
        }
        return lifeContacts;
    }

    /**
     *
     * @return KievStar contacts
     */
    public ArrayList <Contact> getKievStarContacts(){
        ArrayList <Contact> kievStarContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++ ){
            if(contacts.get(i).getNumber().startsWith("097"))
                kievStarContacts.add(contacts.get(i));
        }
        return kievStarContacts;
    }

    private int findPosition(Contact contact) {
        return this.contacts.indexOf(contact);
    }
    private int findLastPosition(Contact contact) {
        return this.contacts.lastIndexOf(contact);
    }
}