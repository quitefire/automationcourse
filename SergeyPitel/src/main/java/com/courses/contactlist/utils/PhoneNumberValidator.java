package com.courses.contactlist.utils;


import com.courses.contactlist.exceptions.InvalidPhoneNumberException;

public class PhoneNumberValidator {

    public static String formatNumber(String phoneNumber) {
        return phoneNumber.replaceAll("\\s", "");
    }

    /**
     * Helper method to check if entered phone number has valid format.
     *
     * @param phoneNumber is a number under check
     * @throws InvalidPhoneNumberException if phone number has invalid format
     */
    public static boolean checkIfValidPhoneNumber(String phoneNumber) {
        String temp = formatNumber(phoneNumber);
        if (temp.startsWith("0") && temp.matches("[0-9]+") && temp.length() == 10) {
            return true;
        }
        throw new InvalidPhoneNumberException("Invalid number format");
    }
}
