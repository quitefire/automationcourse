package com.courses.homeworkTask1;

public class ContactListRun {
    public static void main(String args[]) {
        Boolean exit = false;
        Boolean found;
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ContactList myList = new ContactList(100);

        //List of contacts
        myList.contacts.add(0, Contact.createContact("Olga", "0979589255"));
        myList.contacts.add(1, Contact.createContact("Tanya", "0939589256"));
        myList.contacts.add(2, Contact.createContact("Anton", "0969589257"));
        myList.contacts.add(3, Contact.createContact("Lena", "0979589258"));
        myList.contacts.add(4, Contact.createContact("Igor", "0979589259"));
        myList.contacts.add(5, Contact.createContact("Vasya", "0999589250"));
        myList.contacts.add(6, Contact.createContact("Petya", "0999589234"));
        myList.contacts.add(7, Contact.createContact("Gena", "0939589245"));

        while (!exit) {
            System.out.println("\nEnter your choice \n");
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    //Add new contact
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    if (myList.isValidPhone(phoneNumber)) {
                        Contact newcontact = Contact.createContact(name, phoneNumber);
                        myList.addContact(newcontact);
                    }
                    break;
                case 1:
                    //Remove contact
                    System.out.println("Enter the Contact name you want to remove");
                    String nameToRemove = scanner.nextLine();
                    found = false;
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                        if (myList.getContacts().get(i).getName().equals(nameToRemove)) {
                            myList.removeContact(myList.getContacts().get(i));
                            System.out.println("Contact is removed");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact " + nameToRemove + " is not found!");
                    }
                    break;

                case 2:
                    //Search contact
                    System.out.println("Enter the Contact name you are searching for");
                    String searchName = scanner.nextLine();
                    found = false;
                    for (int i = 0; i < myList.getContacts().size(); i++) {
                        if (myList.getContacts().get(i).getName().contains(searchName)) {
                            System.out.println("Contact is found: " + myList.getContacts().get(i).getName() + " " + myList.getContacts().get(i).getNumber());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact " + searchName + " is not found!");
                    }
                    break;
                case 3:
                    //Update contact name
                    System.out.println("Enter the Contact name you want to update");
                    String oldContactName = scanner.nextLine();
                    found = false;
                    for (int j = 0; j < myList.getContacts().size(); j++) {
                        if (myList.getContacts().get(j).getName().equals(oldContactName)) {
                            System.out.println("Enter the new Contact Name");
                            String newName = scanner.nextLine();
                            System.out.println("Enter the new Contact Phone Number");
                            String newNumber = scanner.nextLine();
                            if (myList.isValidPhone(newNumber)) {
                                myList.updateContact(myList.getContacts().get(j), Contact.createContact(newName, newNumber));
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                            System.out.println("Contact " + oldContactName + " is not found!");
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
                    //Remove last contact
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
                    for (int i = 0; i < myList.getLifeContacts().size(); i++) {
                           System.out.println("Name: " + myList.getLifeContacts().get(i).getName() + ", Phone Number: " + myList.getLifeContacts().get(i).getNumber());
                    }
                    break;
                case 9:
                    ///Show KievStar contacts
                    System.out.println("KievStar contacts:");
                    for (int i = 0; i < myList.getKievStarContacts().size(); i++) {
                        System.out.println("Name: " + myList.getKievStarContacts().get(i).getName() + ", Phone Number: " + myList.getKievStarContacts().get(i).getNumber());
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