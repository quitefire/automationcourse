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

    void removeLast() {
        int lastIndex = contacts.lastIndexOf(contacts);
        contacts.remove(lastIndex);
    }

    public Contact findContact(Contact person) {

        for(int i =0; i < contacts.size();i++){

            if(person.equals(contacts.get(i))){
                System.out.println("Contact found");
                return contacts.get(i);
            }
        }
        return null;
    }

    void removeContact(Contact person) {
        for (int i = 0; i < contacts.size(); i++) {
            if (person.equals(contacts.get(i))) {
                contacts.remove(i);
            }
        }
    }

    void updateContactInfo(Contact person, String name) throws Exception {

        for(int i =0; i < contacts.size();i++){

            if(person.equals(contacts.get(i))){
                contacts.get(i).setName(name);
            }
        }
    }

    void showAllContacts() {
        System.out.println(contacts);

    }

    void showFirstFiveContacts() {

        for (int i = 0; i < contacts.size(); i++) {
            if (i < 5) {
                System.out.println(contacts.get(i).getName());
                System.out.println(contacts.get(i).getNumber());
            }
        }
    }

    void showLastFiveContacts() {
        System.out.println(contacts.size());
        int count = 0;
        for (int i = contacts.size()-1; i > 0; i--) {

            if (count < 5) {
                System.out.println(contacts.get(i).getName());
                System.out.println(contacts.get(i).getNumber());
            }
            count ++;
        }
    }

    //was realised in setNumber
    void numberValidation(){

    }

    void showLifeContacts() {
        String [] lifeCode = {"063","073"};
        for(Contact item : contacts){
            if(item.getNumber().contains(lifeCode[0])|| item.getNumber().contains(lifeCode[1])){
                System.out.println(item.getName()+" "+item.getNumber());
            }
        }

    }

    void showKiyvstarContacts() {
        String [] kievStarCode = {"067","097"};
        for(Contact item : contacts){
            if(item.getNumber().contains(kievStarCode[0])|| item.getNumber().contains(kievStarCode[1])){
                System.out.println(item.getName()+" "+item.getNumber());
            }
        }
    }
}
