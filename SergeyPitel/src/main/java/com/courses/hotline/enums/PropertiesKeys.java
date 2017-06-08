package com.courses.hotline.enums;


public enum PropertiesKeys {

    REGISTRATION_SUCCESSFUL_MESSAGE_KEY("registration_successful_message"),
    REGISTRATION_EMPTY_FIELD_MESSAGE_KEY("registration_empty_field_message"),
    REGISTRATION_INVALID_FORMAT_MESSAGE_KEY("registration_invalid_format_message"),
    REGISTRATION_SHORT_PASSWORD_MESSAGE_KEY("registration_short_password_message"),
    REGISTRATION_ALREADY_TAKEN_EMAIL_MESSAGE_KEY("registration_already_taken_email_message"),
    REGISTRATION_ALREADY_TAKEN_NICKNAME_MESSAGE_KEY("registration_already_taken_nickname_message");


    private String key;

    PropertiesKeys(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
