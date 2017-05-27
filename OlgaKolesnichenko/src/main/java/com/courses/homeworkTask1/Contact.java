package com.courses.homeworkTask1;

public class Contact {
    private String name;
    private int number;

    public Contact(int number,String name) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number
     * @param name
     * @return
     */
    public static Contact createContact(int number, String name){
        return new Contact(number,name);
    }
}
