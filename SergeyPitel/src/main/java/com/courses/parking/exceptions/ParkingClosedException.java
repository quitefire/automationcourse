package com.courses.parking.exceptions;


public class ParkingClosedException extends RuntimeException {

    public ParkingClosedException(String message) {
        super(message);
    }
}
