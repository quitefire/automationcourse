package com.courses.globalmoney.data;

public class UserData {

    public static final UserData validData = new UserData("380633699425", "12345679", "91687567485143");
    public static final UserData invalidData = new UserData("380633699425", "xxxx", "91687567485143");

    private String userName;
    private String password;
    private String userId;


    public UserData(String userName, String password, String userId) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;

    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
