package com.courses.homeworkTask1.Exceptions;

/**
 * Created by admin on 29/05/2017.
 */
public class InvalidPhoneNumberException extends RuntimeException {

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
