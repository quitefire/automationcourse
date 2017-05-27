package com.courses.oop_entry_test.task;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param text
     * @return sorted by natural order array of unique words
     */
    public static String[] getUniqueSortedWords(String text) {
        return sortWords(getUniqueWords(getWords(text)));
    }

    /**
     * @param text
     * @return array with words, get from receive text
     * if received argument is null
     * or text length is zero
     * return array with zero length
     */
    public static String[] getWords(String text) {
        return text == null || text.isEmpty() ? new String[0] : text.split("; ");
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {
        Set<String> unique = new LinkedHashSet<>(Arrays.asList(words));
        return unique.toArray(new String[unique.size()]);
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {
        Set<String> sorted = new TreeSet<>(Arrays.asList(uniqueWords));
        return sorted.toArray(new String[sorted.size()]);
    }
}
