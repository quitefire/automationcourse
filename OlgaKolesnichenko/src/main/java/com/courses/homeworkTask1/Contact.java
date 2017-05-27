package com.courses.homeworkTask1;

public class Contact {
    private String name;
    private String number;

    public Contact(String number,String name) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    /**
     *
     * @param number
     * @param name
     * @return
     */
    public static Contact createContact(String number, String name){
        return new Contact(number,name);
    }
}
