package com.entry.test.oop;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class TextUtils {
    /**
     * Method contains inside of its body three another methods.
     * Each of this method defined below.
     *
     * @param  text
     * @return sorted by natural order array of unique words
     * */
    public static String[] getUniqueSortedWords(String text) {
//        TODO find mistake and correct it, so the method works correctly
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

        if(text == null  || text.length()==0){
            return new String[]{};
        }
        return text.split("; ");
    }
    /**
     * @param words array with words
     * @return  array with unique words
     * */
    public static String[] getUniqueWords(String[] words) {
        //String[] actual = {"cab", "abc", "cab", "cab", "bac", "bac"};
        Set<String> uniqueList = new LinkedHashSet<>();
        for(int i =0; i < words.length; i++){
            uniqueList.add(words[i]);
        }
        String[] result = uniqueList.toArray(new String[0]);

        return result;
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
