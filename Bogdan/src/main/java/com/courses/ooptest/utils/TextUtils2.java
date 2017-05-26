package com.courses.ooptest.utils;

import java.util.Arrays;


public class TextUtils2 {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text) {
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }

    /**
     * @param text
     * @return array with words, get from receive text
     * if received argument is null
     * or text length is zero
     * return array with zero length
     */
    public static String[] getWords(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }
        return text.split("; ");
    }


    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {
        if (words == null || words.length == 0) return new String[0];
        return copyUniqueWords(words);
    }

    private static String[] copyUniqueWords(String[] words) {
        String[] uniqueWords = new String[words.length];
        int counter = 0;
        for (String word : words) {
            if (!contains(uniqueWords, word)) {
                uniqueWords[counter++] = word;
            }
        }
        return trimArray(uniqueWords, counter);
    }

    private static String[] trimArray(String[] array, int length) {
        return Arrays.copyOf(array, length);
    }

    private static boolean contains(String[] words, String word) {
        for (String aWord : words) {
            if (aWord != null && word.equals(aWord)) return true;
        }
        return false;
    }


    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {

        for (int i = uniqueWords.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (uniqueWords[j].compareTo(uniqueWords[j + 1]) > 0) {
                    swap(uniqueWords, j, j + 1);
                }
            }
        return uniqueWords;
    }

    private static void swap(String[] uniqueWords, int index1, int index2) {
        String temp = uniqueWords[index1];
        uniqueWords[index1] = uniqueWords[index2];
        uniqueWords[index2] = temp;
    }
}