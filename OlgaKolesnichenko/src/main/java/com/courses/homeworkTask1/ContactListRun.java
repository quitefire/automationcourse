package com.courses.homeworkTask1;

public class ContactListRun {
    public static void main(String args[]) {
        Boolean exit = false;
        Boolean found;
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ContactList myList = new ContactList(100);

        myList.contacts.add(0, Contact.createContact("0999589255", "Olga"));
        myList.contacts.add(1, Contact.createContact("0939589256", "Tanya"));
        myList.contacts.add(2, Contact.createContact("0969589257", "Anton"));
        myList.contacts.add(3, Contact.createContact("0979589258", "Lena"));
        myList.contacts.add(4, Contact.createContact("0999589259", "Igor"));
        myList.contacts.add(5, Contact.createContact("0999589250", "Vasya"));
        myList.contacts.add(6, Contact.createContact("0999589234", "Petya"));
        myList.contacts.add(7, Contact.createContact("0999589245", "Gena"));

        while (!exit) {
            System.out.println("Enter your choice \n");
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Enter number of contacts to add to the Contact List");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Enter phone number:");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter Name:");
                        String name = scanner.nextLine();
                        Contact newcontact = Contact.createContact(phoneNumber, name);
                        myList.addContact(newcontact);
                    }
                    break;
                case 1:
                    //remove contact
                    System.out.println("Enter the Contact name you want to remove");
                    String nameToRemove = scanner.nextLine();
                    found = false;
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                        if (myList.getContacts().get(i).getName().contains(nameToRemove)) {
                            myList.removeContact(myList.getContacts().get(i));
                            System.out.println("Contact is removed");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact " + nameToRemove + " is not found! Try again!");
                    }
                    break;

                case 2:
                    //Search contact
                    System.out.println("Enter the Contact name you are searching for");
                    String searchName = scanner.nextLine();
                    found = false;
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                        if (myList.getContacts().get(i).getName().equals(searchName)) {
                            System.out.println("Contact is found: " + myList.getContacts().get(i).getName() + " " + myList.getContacts().get(i).getNumber());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact " + searchName + " is not found! Try again!");
                    }
                    break;
                case 3:
                    //Update contact name
                    System.out.println("Enter the Contact name you want to update");
                    String oldContactName = scanner.nextLine();

                    for (int j = 0; j < myList.getContacts().size(); j++) {
                        if (myList.getContacts().get(j).getName().equals(oldContactName)) {
                            System.out.println("Enter the new Contact Name");
                            String newName = scanner.nextLine();
                            System.out.println("Enter the new Contact Phone Number");
                            String newNumber = scanner.nextLine();
                            myList.updateContact(myList.getContacts().get(j), Contact.createContact(newNumber, newName));
                        } else {
                            System.out.println("No contact " + oldContactName + " found! Try again!");
                        }
                    }
                    break;
                case 4:
                    //Show all contacts
                    if(myList.getContacts().isEmpty()){
                        System.out.println("Empty contact list \n");

                    }
                    else {
                        System.out.println("Contact list");
                        for (int i = 0; i < myList.getContacts().size(); i++) {
                            System.out.println("Name: " + myList.getContacts().get(i).getName() + ", Phone Number: " + myList.getContacts().get(i).getNumber());
                        }
                    }
                    break;
                case 5:
                    //remove last contact
                    myList.removeLastContact(myList.getContacts().get(myList.getContacts().size()-1));
                    System.out.println("Last contact is removed!");
                    break;
                case 6:
                    //Show first five contacts
                    if(myList.getContacts().size()-1 <= 4){
                        System.out.println("There are less then 5 contacts! \n");
                    }
                    else {
                        System.out.println("First five contacts:\n");
                        for (int i = 0; i < myList.getFirstFiveContacts().size(); i++) {
                            System.out.println("Name: " + myList.getFirstFiveContacts().get(i).getName() + "; Phone: " + myList.getFirstFiveContacts().get(i).getNumber());
                        }

                    }
                    break;
                case 7:
                    //Show last five contacts
                    if(myList.getContacts().size()-1 <= 4){
                        System.out.println("There are less then 5 contacts! \n");

                    }
                    else {
                        System.out.println("Last five contacts:\n");
                        for (int i = 0; i < myList.getLastFiveContacts().size(); i++) {
                            System.out.println("Name: " + myList.getLastFiveContacts().get(i).getName() + "; Phone: " + myList.getFirstFiveContacts().get(i).getNumber());
                        }
                    }
                    break;
                case 8:
                    //Show Life contacts
                    System.out.println("Life contacts:");
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                       if (myList.getContacts().get(i).getNumber().startsWith("093")){
                           System.out.println("Name: " + myList.getContacts().get(i).getName() + ", Phone Number: " + myList.getContacts().get(i).getNumber());
                       }
                    }
                    break;
                case 9:
                    //Show KievStar contacts
                    System.out.println("KievStar contacts:");
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                        if (myList.getContacts().get(i).getNumber().startsWith("097")){
                            System.out.println("Name: " + myList.getContacts().get(i).getName() + ", Phone Number: " + myList.getContacts().get(i).getNumber());
                        }
                    }
                    break;
                case 10:
                    exit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Enter 0 to add new contact");
        System.out.println("Enter 1 to remove contact");
        System.out.println("Enter 2 to search contact");
        System.out.println("Enter 3 to update contact");
        System.out.println("Enter 4 to view contact list");
        System.out.println("Enter 5 to remove last contact");
        System.out.println("Enter 6 to show 5 first contacts");
        System.out.println("Enter 7 to show 5 last contacts");
        System.out.println("Enter 8 to show Life contacts");
        System.out.println("Enter 9 to show KievStar contacts");
        System.out.println("Enter 10 to exit");
    }
}