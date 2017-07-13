package com.courses.hotline.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationUtil {

    private static final String DOMAIN_NAME = "@yopmail.com";
    private static final String NICKNAME = "com.sergoneeigh";
    private static final String PATTERN = "yyyy-MM-ddHH-mm-ss";

    public static String generateEmail() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        return simpleDateFormat.format(new Date()) + DOMAIN_NAME;
    }

    public static String generateNickname() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
        return NICKNAME + simpleDateFormat.format(new Date());
    }

    public static User getExistingUser() {
        return new User("Testuserhotline", "testuserhotline@yopmail.com", "1234567");
    }

    public static class User {

        private String nickname;
        private String email;
        private String password;

        public User(String nickname, String email, String password) {
            this.nickname = nickname;
            this.email = email;
            this.password = password;
        }

        public String getNickname() {
            return nickname;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
