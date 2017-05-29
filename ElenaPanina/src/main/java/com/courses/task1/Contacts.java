package com.courses.task1;

/**
 * Created by elena on 28.05.17.
 */
public class Contacts {
    public String name;
    public String surname;
    public int number;

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public Contacts(String name, String surname, int number){
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    public static Contacts addContact(String name, String surname, int number){
        return new Contacts(name, surname, number);
    }





}
