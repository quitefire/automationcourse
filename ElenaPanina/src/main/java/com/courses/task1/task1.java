package com.courses.task1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.courses.task1.Contacts;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by elena on 28.05.17.
 */
public class task1 {
    public static void main(String[] args) throws IOException {

        //TreeSet<Contacts> ContactList = new TreeSet<>();
        ArrayList<Contacts> ContactArray = new ArrayList<>();

        boolean n = true;
        while (n) {
            System.out.println("Choose option:");
            System.out.println("1 - add contact");
            System.out.println("2 - search contact");
            System.out.println("3 - remove contact");
            System.out.println("4 - remove last contact");
            System.out.println("5 - show all contacts");
            System.out.println("6 - edit contact");
            System.out.println("exit - finish programm");
            // System.out.println("4 - remove last contact");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();

            if (s.equals("1")) {
                System.out.println("Imya, sestra, imya!!");
                String name = reader.readLine();
                System.out.println("Enter surname:");
                String surname = reader.readLine();
                System.out.println("Enter number:");
                String S_number = reader.readLine();
                int number = Integer.parseInt(S_number);
                Contacts contact = Contacts.addContact(name, surname, number);
                ContactArray.add(contact);
                System.out.println("Contact has been added");
                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                n = true;

            }

            if (s.equals("2")){
                System.out.println("Enter surname:");
                String c = reader.readLine();
                for (int i=0; i<ContactArray.size(); i++){
                    Contacts contact = ContactArray.get(i);
                    String surname = contact.getSurname();
                    if (surname.equals(c))
                        System.out.println(contact.getName() +" "+contact.getSurname()+" "+contact.getNumber());

                }
                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                    n = true;
            }

            if (s.equals("3")){

                System.out.println("Enter name and surname divided by space:");
                String r = reader.readLine();
                String[] rs = r.split(" ");
                String InName = rs[0];
                String InSurname = rs[1];

                for (int i=0; i<ContactArray.size(); i++) {
                    Contacts contact = ContactArray.get(i);

                    if ((InName.equals(contact.getName())) && (InSurname.equals(contact.getSurname()))) {
                        ContactArray.remove(i);
                        System.out.println("Contact has been removed");
                    }

                }
                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                    n = true;
            }

            if (s.equals("4")){
                ContactArray.remove(ContactArray.size()-1);
                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                    n = true;
            }

            if (s.equals("5")){

                for (int i=0; i<ContactArray.size(); i++) {

                    System.out.println(ContactArray.get(i).getName() +" "+ContactArray.get(i).getSurname()+" "+ContactArray.get(i).getNumber());
                }
                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                    n = true;

            }

            if (s.equals("6")){
                System.out.println("Enter surname:");
                String surname = reader.readLine();
                for (int i=0; i<ContactArray.size(); i++) {
                    Contacts contact = ContactArray.get(i);
                    if (contact.getSurname().equals(surname)){
                        System.out.println(ContactArray.get(i).getName() +" "+ContactArray.get(i).getSurname()+" "+ContactArray.get(i).getNumber());
                        System.out.println("Enter new name:");
                        String newName = reader.readLine();
                        if (!newName.equals(""))
                            contact.setName(newName);
                        System.out.println("Enter new surname:");
                        String newSurname = reader.readLine();
                        if (!newSurname.equals(""))
                            contact.setSurname(newSurname);
                        System.out.println("Enter new number:");
                        String newNumberS = reader.readLine();
                        if(!newNumberS.equals("")){
                            int newNumber = Integer.parseInt(newNumberS);
                            contact.setNumber(newNumber);
                        }
                        System.out.println("Contact has been changed:");
                        System.out.println(ContactArray.get(i).getName() +" "+ContactArray.get(i).getSurname()+" "+ContactArray.get(i).getNumber());

                        }
                    }

                System.out.println("Press Enter to open menu");
                String exit = reader.readLine();
                if(exit.equals("0"))
                    n = true;
            }

            if(s.equals("exit")){
                n = false;
            }


        }
    }
}
