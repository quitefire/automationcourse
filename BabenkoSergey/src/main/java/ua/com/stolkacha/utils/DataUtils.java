package ua.com.stolkacha.utils;

import org.apache.commons.lang3.StringUtils;
import ua.com.stolkacha.domain.Credential;
import java.io.*;
import java.util.*;


/**
 * Created by Serhii Babenko on 6/5/2017.
 */
public class DataUtils {

    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
            String current;
            while ((current = bufferedReader.readLine()) != null) {
                lines.add(current);

            }

            return lines;
        } catch (IOException e) {
            //TODO : add logging
        }
        return lines;

    }


    public static Iterator<Object[]> getRegistrationCredentials() {

        List<String> lines = readLinesFromFile(MyProperties.getProperty("login_data_file_path"));
        List<Object[]> credentials = new ArrayList<>();

        for (String line : lines) {
            if (StringUtils.isNoneEmpty(line)) {
                List<String> split = Arrays.asList(line.split(";"));
                if (split.size() == 5) {
                    credentials.add(new Object[]{new Credential(split.get(0), split.get(1), split.get(2), split.get(3), split.get(4))});
                }
            }
        }
        return credentials.iterator();
    }


    public static String getMessage(String id) {
        List<String> lines = readLinesFromFile(MyProperties.getProperty("messages_file"));
        for (String line : lines) {
            if (StringUtils.isNoneEmpty(line) && line.contains(id)) {
                String[] message = line.split(id+"=");
                return message[1].replaceAll("\"", "");
            }
        }
        return null;
    }
}
