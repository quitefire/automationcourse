package homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Babenko on 29.05.2017.
 */
public class ContactList {


    private List<Contact> contactList;
    public static final String[] LIFE = {"063","073"};
    public static final String[] KYIVSTAR = {"067"};

    public ContactList() {
        contactList = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void removeLast() {
        if (!contactList.isEmpty()) {
            contactList.remove(contactList.size() - 1);
        }
    }

    public Contact findContact(Contact contact) {
        for (Contact item : contactList) {
            if (item.equals(contact)) return item;
        }
        return null;
    }

    public void removeContact(Contact contact) {
        for (Contact item : contactList) {
            if (item.equals(contact)) {
                contactList.remove(item);
                break;
            }
        }
    }

    public void updateContactInfo(Contact contact, String firstName) {
        for (Contact c : contactList) {
            if (c.equals(contact)) {
                c.setFirstName(firstName);
                break;
            }
        }
    }

    public void showAllContacts() {
            for (Contact contact : contactList) {
                System.out.print(contact);
            }
    }

    public void showFirstFiveContacts() {
        //read on ternary operator
        int size = contactList.size() < 5 ? contactList.size() : 5;
        for (int i = 0; i < size; i++) {
            //print method calls toString on a parameter internally
            System.out.print(contactList.get(i));
        }
    }

    public void showLastFiveContacts() {
        //read on ternary operator
        int size = contactList.size() >= 5 ? contactList.size()-5 : 0;
        for (int i = size; i < contactList.size(); i++) {
            //print method calls toString on a parameter internally
            System.out.print(contactList.get(i));
        }
    }

    public void showLifeContacts() {
        for (Contact contact : contactList) {
            for (String prefix:LIFE) {
                if ((contact.getPhone()).startsWith(prefix)) {
                    System.out.print(contact);
                }
            }
        }

    }

    public void showKiyvstarContacts() {
        for (Contact contact : contactList) {
            for (String prefix : KYIVSTAR) {
                if ((contact.getPhone()).regionMatches(0, prefix, 0, 3)) {
                    System.out.print(contact);
                }
            }
        }
    }


}
