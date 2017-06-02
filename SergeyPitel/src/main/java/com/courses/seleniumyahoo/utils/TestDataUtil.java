package com.courses.seleniumyahoo.utils;


import java.io.*;
import java.util.*;

public class TestDataUtil {

    private static final int COLUMN_AMOUNT = 2;

    public static String readFromCvsFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
        String current;
        while ((current = bufferedReader.readLine()) != null) {
            content.append(current).append(", ");
        }
        return content.toString();
    }

    public static Object[][] parseCompanyStockSymbols(String text) {
        List<Object> list = Arrays.asList(text.split(", "));
        List<Object[]> objects = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            objects.add(new Object[]{list.get(i), list.get(i + 1)});
            i++;
        }

        Object[][] testData = new Object[objects.size()][COLUMN_AMOUNT];
        for (int i = 0; i < objects.size(); i++) {
            for (int j = 0; j < COLUMN_AMOUNT; j++) {
                testData[i][j] = objects.get(i)[j];
            }
        }
        return testData;
    }
}

