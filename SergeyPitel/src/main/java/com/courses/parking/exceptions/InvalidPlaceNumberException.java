package com.courses.parking.exceptions;


public class InvalidPlaceNumberException extends RuntimeException {

    public InvalidPlaceNumberException(String message) {
        super(message);
    }
}
