package com.courses.globalmoney.data;

public class RegistrationData {

    public static final RegistrationData validEmail = new RegistrationData("xivo@p33.org", "12345", "12345");

    private String email;
    private String phoneNumber;
    private String firstPassword;
    private String secondPassword;

    public RegistrationData(String email, String firstPassword, String secondPassword) {
        this.email = email;
        this.firstPassword = firstPassword;
        this.secondPassword = secondPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public String getSecondPassword() {
        return secondPassword;
    }


}