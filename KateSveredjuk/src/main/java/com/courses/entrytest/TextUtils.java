package com.courses.entrytest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
//        TODO find mistake and correct it, so the method works correctly
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }

    static String[] getWords(String text) {
        if (text != null) {
            String[] words = text.split("; ");
            if (text.equals("")) {
                return new String[0];
            }
            return words;
        }
        return new String[0];
    }

    /**
     * @param uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     */
    public static String[] sortWords(String[] uniqueWords) {
        TreeSet<String> sort = new TreeSet<String>(Arrays.asList(uniqueWords));
        String[] sortWords = new String[sort.size()];
        Iterator<String> iterator = sort.iterator();
        for (int i = 0; i < sortWords.length; i++) {
            sortWords[i] = iterator.next();
        }
        return sortWords;
    }

    /**
     * @param words array with words
     * @return array with unique words
     */
    public static String[] getUniqueWords(String[] words) {
        LinkedHashSet<String> uniqueSet = new LinkedHashSet<String>(Arrays.asList(words));
        String[] uniqueArray = new String[uniqueSet.size()];
        Iterator<String> iterator = uniqueSet.iterator();
        for (int i = 0; i < uniqueArray.length; i++) {
            uniqueArray[i] = iterator.next();
        }
        return uniqueArray;
    }
}
