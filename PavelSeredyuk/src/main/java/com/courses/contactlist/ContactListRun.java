package com.courses.contactlist;

import java.util.ArrayList;

/**
 * Created by dtv on 29.05.2017.
 */
public class ContactListRun {
    public static void main(String[] args) throws Exception {
        ContactList cList = new ContactList();
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact one = new Contact("0636528565", "Petro Timoshenko");
        Contact two = new Contact("0632356554", "Mike Linder");
        Contact three = new Contact("0732356555", "Jhon Lunkaster");
        Contact four = new Contact("0672356558", "Kolya Serga");
        Contact five = new Contact("0972356858", "Kolya Sergienko");
        Contact six = new Contact("0972356559", "Petya Masachusec");
        Contact seven = new Contact("0632356539","Petya Serga");

        cList.addContact(one);
        cList.addContact(two);
        cList.addContact(three);
        cList.addContact(four);

//        System.out.println("Before Del");
//        cList.showAllContacts();
//
//        System.out.println("Deleted = " + cList.removeLast());
//
//        System.out.println("After Del");
        //cList.showAllContacts();
        cList.addContact(five);
        cList.addContact(six);
        cList.addContact(seven);
        //cList.showFirstFiveContacts();
        cList.showLastFiveContacts();
        //cList.showLastFiveContacts();
//        cList.showLifeContacts();
//        cList.showKiyvstarContacts();

        //cList.findContact(one);


        //cList.findContact(seven);
    }
}
