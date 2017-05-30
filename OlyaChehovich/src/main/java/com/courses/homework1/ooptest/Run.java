package com.courses.homework1.ooptest;

import java.io.IOException;
import java.util.Arrays;


public class Run {
    public static void main(String[] args) throws IOException {
//        Don't touch this code
        String text = FileUtils.readFile("C:\\Users\\user\\IdeaProjects\\ooptest\\src\\main\\resources\\WarAndPeace.txt");
//        You can give to getUniqueSortedWords your own String (with delimiters "; ")
        System.out.println(text);
        String[] result = TextUtils.getUniqueSortedWords(text);
        System.out.println(Arrays.toString(result));
        // for (int i = 0; i < result.length; i++) System.out.println(result[i]);

    }
}
