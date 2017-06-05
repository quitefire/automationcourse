package com.courses.hotline.utils;

/**
 * Helper class
 */
public class TextUtils {

    public static String removeNonNumericCharacters(String str) {
        return str.replaceAll("[^0-9-]", "");
    }

    public static int parseInt(String str) {
        return Integer.parseInt(removeNonNumericCharacters(str));
    }

    public static int[] parsePriceRange(String str) {
        String[] range = removeNonNumericCharacters(str).split("-");
        int[] numRange = new int[2];
        numRange[0] = Integer.parseInt(range[0]);
        numRange[1] = Integer.parseInt(range[1]);
        return numRange;
    }
}
