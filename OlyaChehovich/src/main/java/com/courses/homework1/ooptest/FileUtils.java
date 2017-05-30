package com.courses.homework1.ooptest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileUtils {
    public static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\user\\IdeaProjects\\ooptest\\src\\main\\resources\\WarAndPeace.txt")));
        StringBuilder sb = new StringBuilder();
        while (br.ready()){
            sb.append(br.readLine()).append("\n");
        }
        return sb.toString().substring(1);
    }
}
