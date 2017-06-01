package com.courses.homeworkTask2.Exceptions;

/**
 * Created by admin on 01/06/2017.
 */
public class ParkingIsClosedException extends RuntimeException{
   public ParkingIsClosedException(String message) {
       super(message);
   }
}
