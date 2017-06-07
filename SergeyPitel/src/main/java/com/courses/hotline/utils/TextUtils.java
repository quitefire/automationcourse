package com.courses.hotline.utils;

/**
 * Helper class
 */
public class TextUtils {

    public static String removeNonNumericCharacters(String str) {
        return str.replaceAll("[^0-9-]", "");
    }

    public static int parseInt(String str) throws NumberFormatException {
        return Integer.parseInt(removeNonNumericCharacters(str));
    }

    public static int parseResultAmount(String str) {
        return Integer.parseInt(str.replaceAll(".*\\(|\\).*", ""));
    }

    public static int[] parsePriceRange(String str) throws NumberFormatException {
        int[] numRange;
        String numbers = removeNonNumericCharacters(str);
        if (str.contains("-")) {
            numRange = new int[2];
            String[] range = numbers.split("-");
            numRange[0] = Integer.parseInt(range[0]);
            numRange[1] = Integer.parseInt(range[1]);
        } else {
            numRange = new int[2];
            numRange[0] = Integer.parseInt(numbers);
            numRange[1] = Integer.MAX_VALUE;
        }
        return numRange;
    }
}
