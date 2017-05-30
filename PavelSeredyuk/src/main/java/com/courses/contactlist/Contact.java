package com.courses.contactlist;

/**
 * Created by dtv on 29.05.2017.
 */
public class Contact {
    private String number;
    private String name;

    Contact(String number, String name){
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws Exception {

      if(number.matches("\\d"))
      {
            this.number = number;
      }else {
          throw new Exception("number invalid");
      }


    }
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.matches("[a-zA-Z]")){
            this.name = name;
        }else{
            throw new Exception("name invalid");
        }

    }

    @Override
    public String toString() {
        return "Name: " + name + "   " + "Number: " + number + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (getNumber() != null ? !getNumber().equals(contact.getNumber()) : contact.getNumber() != null) return false;
        return getName() != null ? getName().equals(contact.getName()) : contact.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getNumber() != null ? getNumber().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
