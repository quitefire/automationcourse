package com.courses.homeworkTask1;

public class ContactListRun {
    public static void main(String args[]) {
        Boolean exit = false;
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ContactList myList = new ContactList();

        //List of contacts
        myList.addContact(new Contact("Olga", "0999589255"));
        myList.addContact(new Contact("Lena", "0939589256"));
        myList.addContact(new Contact("Anton", "0969589257"));
        myList.addContact(new Contact("Lena", "0979589258"));
        myList.addContact(new Contact("Igor", "0979589259"));
        myList.addContact(new Contact("Petya", "0999589234"));
        myList.addContact(new Contact("Gena", "0939589245"));

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
                    myList.addContact(new Contact(name, phoneNumber));
                    break;
                case 1:
                    //Remove contact
                    System.out.println("Enter the Contact name you want to remove");
                    String nameToRemove = scanner.nextLine();
                    myList.removeContact(myList.searchByName(nameToRemove));
                    System.out.println("Done!");
                    break;
                case 2:
                    //Search contact
                    System.out.println("Enter the Contact name you are searching for");
                    String searchName = scanner.nextLine();
                    System.out.println(myList.searchByName(searchName));
                    break;
                case 3:
                    //Update contact name
                    System.out.println("Enter the Contact name you want to update");
                    String oldContactName = scanner.nextLine();
                    System.out.println("Enter the new Contact Name");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new Contact Phone Number");
                    String newNumber = scanner.nextLine();
                    myList.updateContact(myList.searchByName(oldContactName), new Contact(newName, newNumber));
                    break;
                case 4:
                    //Show all contacts
                    System.out.println("Contact list:");
                    System.out.println(myList.getContacts());
                    break;
                case 5:
                    //Remove last contact
                    myList.removeLastContact();
                    System.out.println("Last contact is removed!");
                    break;
                case 6:
                    //Show first five contacts
                    System.out.println("First five contacts:\n");
                    System.out.println(myList.getFirstFiveContacts());

                    break;
                case 7:
                    //Show last five contacts
                    System.out.println("Last five contacts:\n");
                    System.out.println(myList.getLastFiveContacts());
                    break;
                case 8:
                    //Show Life contacts
                    System.out.println("Life contacts:");
                    System.out.println(myList.getLifeContacts());
                    break;
                case 9:
                    ///Show KievStar contacts
                    System.out.println("KievStar contacts:");
                    System.out.println(myList.getKievStarContacts());
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