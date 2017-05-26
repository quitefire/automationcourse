package com.courses.ooptest;


import com.courses.ooptest.utils.FileUtils;
import com.courses.ooptest.utils.TextUtils;

import java.io.IOException;
import java.util.Arrays;

public class Run {
    public static void main(String[] args) throws IOException {
//        Don't touch this code
        String text = FileUtils.readFile("/WarAndPeace.txt");
//        You can give to getUniqueSortedWords your own String (with delimiters "; ")
        String[] result = TextUtils.getUniqueSortedWords(text);
        System.out.println(Arrays.toString(result));
    }
}
