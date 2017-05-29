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
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).equals(contact)) {
               // Contact contactToUpdate = contactList.get(i);
                //contactToUpdate.setFirstName(firstName);
                contactList.get(i).setFirstName(firstName);
                contactList.set(i, contactList.get(i));
                break;
            }
        }
    }

    public void showAllContacts() {
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                System.out.print(contact.toString());
            }
        } else throw new NullPointerException();

    }

    public void showFirstFiveContacts() {
        if (contactList.size() <= 5) {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.print(contactList.get(i).toString());
            }
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.print(contactList.get(i).toString());
            }
        }

    }

    public void showLastFiveContacts() {
        if (contactList.size() <= 5) {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.print(contactList.get(i).toString());
            }
        } else {
            for (int i = contactList.size()-5; i < contactList.size(); i++) {
                System.out.print(contactList.get(i).toString());
            }
        }

    }

    public void showLifeContacts() {
        for (Contact contact : contactList) {
            for (String prefix:LIFE) {
                if ((contact.getPhone()).startsWith(prefix)) {
                    System.out.print(contact.toString());
                }
            }
        }

    }

    public void showKiyvstarContacts() {
        for (Contact contact : contactList) {
            for (String prefix : KYIVSTAR) {
                if ((contact.getPhone()).regionMatches(0, prefix, 0, 3)) {
                    System.out.print(contact.toString());
                }
            }
        }
    }


}
