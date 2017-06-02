package com.entry.test.oop;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Vorobiei on 18.05.2016.
 */
public class Run {
    public static void main(String[] args) throws IOException {
//        Don't touch this code
        String text = FileUtils.readFile("src/main/resources/WarAndPeace.txt");
//        You can give to getUniqueSortedWords your own String (with delimiters "; ")
        System.out.println(text);
        String[] result = TextUtils.getUniqueSortedWords(text);
        System.out.println(Arrays.toString(result));
    }
}
