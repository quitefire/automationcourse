package ua.com.stolkacha.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Serhii Babenko on 6/5/2017.
 */
public class MyProperties {
    private static Properties property;

    static {
        property = new Properties();
        loadPropertyFile();
    }

    private static boolean loadPropertyFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("E:\\Courses\\automationcourse\\BabenkoSergey\\src\\main\\resources\\config\\settings.properties");
            property.load(reader);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getProperty(String key){
        return property.getProperty(key);
    }




}
