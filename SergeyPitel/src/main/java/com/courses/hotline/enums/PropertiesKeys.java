package com.courses.hotline.enums;


public enum PropertiesKeys {

    REG_SUCCESSFUL_MESSAGE_KEY("registration_successful_message"),
    REG_EMPTY_FIELD_ERROR_MESSAGE_KEY("registration_empty_field_error_message"),
    REG_INVALID_FORMAT_ERROR_MESSAGE_KEY("registration_invalid_format_error_message"),
    REG_SHORT_PASSWORD_ERROR_MESSAGE_KEY("registration_short_password_error_message"),
    REG_ALREADY_TAKEN_EMAIL_ERROR_MESSAGE_KEY("registration_already_taken_email_error_message"),
    REG_ALREADY_TAKEN_NICKNAME_ERROR_MESSAGE_KEY("registration_already_taken_nickname_error_message");

    private String key;

    PropertiesKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
