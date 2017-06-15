package homework1;

/**
 * Created by Serhii Babenko on 29.05.2017.
 */
public class ContactListRun {
    public static void main(String[] args) {
        ContactList m = new ContactList();
        Contact one = new Contact("asdf", "babenko0", "06364576783");
        Contact two = new Contact("Serhii", "babenko1", "0636345678");
        Contact three = new Contact("Serhii", "babenko2", "0676345678");
        Contact one1 = new Contact("Serhii", "babenko3", "0676345678");
        Contact two1 = new Contact("Serhii", "babenko4", "0736345678");
        Contact three1 = new Contact("Serhii", "babenko5", "0676345678");
        Contact one2 = new Contact("Serhii", "babenko6", "0676345678");
        Contact two2 = new Contact("Serhii", "babenko7", "0676345678");
        Contact three2 = new Contact("Serhii", "babenko8", "0676345678");
        m.addContact(one);
        m.addContact(two);
        m.addContact(three);
        m.addContact(one1);
        m.addContact(two1);
        m.addContact(three1);
        m.addContact(one2);
        m.addContact(two2);
        m.addContact(three2);


        System.out.println("||||| Show all contacts |||||");
        m.showAllContacts();
        System.out.println();
        System.out.println("||||| Remove Last |||||");
        m.removeLast();
        m.showAllContacts();
        System.out.println();
        System.out.println("||||| Remove Contact two |||||");
        m.removeContact(two);
        m.showAllContacts();
        System.out.println();
        System.out.println("||||| Show Firts Five |||||");
        m.showFirstFiveContacts();
        System.out.println();
        System.out.println("||||| Show Last Five |||||");
        m.showLastFiveContacts();
        System.out.println();
        System.out.println("||||| Update Contact three |||||");
        m.updateContactInfo(three,"Dima");
        m.showAllContacts();
        System.out.println();
        System.out.println("||||| Show LIFE |||||");
        m.showLifeContacts();
        System.out.println();
        System.out.println("||||| Show Kyivstar |||||");
        m.showKiyvstarContacts();

    }
}
