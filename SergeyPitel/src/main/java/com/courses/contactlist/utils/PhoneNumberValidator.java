package com.courses.contactlist.utils;


import com.courses.contactlist.exceptions.InvalidPhoneNumberException;

public class PhoneNumberValidator {

    public static final String LIFE_PREFIXES[] = {"063", "093", "073"};
    public static final String KIYVSTAR_PREFIXES[] = {"067", "068", "096", "098"};

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
        String temp = phoneNumber.replaceAll("\\s", "");
        if (temp.startsWith("0") && temp.matches("[0-9]+")) {
            return true;
        }
        throw new InvalidPhoneNumberException("Invalid number format");
    }
}
