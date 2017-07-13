package com.courses.homeworkTask2.Exceptions;

/**
 * Created by admin on 01/06/2017.
 */
public class PlaceIsTakenException extends RuntimeException{
    public PlaceIsTakenException(String message) {
        super(message);
    }
}
