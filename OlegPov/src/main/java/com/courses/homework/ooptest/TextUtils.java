package com.courses.homework.ooptest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param  text
     * @return sorted by natural order array of unique words
     * */
    public static String[] getUniqueSortedWords(String text) {
        String[] words = getWords(text);
        String[] uniqueWords = getUniqueWords(words);
        return sortWords(uniqueWords);
    }
    /**
     * @param text
     * @return array with words, get from receive text
     *          if received argument is null
     *          or text length is zero
     *          return array with zero length
     * */
    public static String[] getWords(String text) {

        if (text==null) {
            return new String[0];
        }

        if (text.equals("")) {
            return new String[0];
        }

        return text.split("; ");
    }

    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {
        String[] uniWords = new String[words.length];
        HashMap<String, String> shMap = new HashMap<String, String>();
        int j=0;
        for (int i=0; i<words.length; i++) {
            if (!shMap.containsKey(words[i])) {
                shMap.put(words[i],"");
                uniWords[j++] = words[i];
            }
        }
        return Arrays.copyOfRange(uniWords, 0, j);
    }

    /**
     * @param  uniqueWords array with unique words
     * @return sorted by natural order array of unique words
     * */
    public static String[] sortWords(String[] uniqueWords) {
        Arrays.sort(uniqueWords);
        return uniqueWords;
    }
}
