package com.courses.week5.yaml;

public class YamlReaderRun {

    public static void main(String[] args) {
        YamlReader reader = new YamlReader();
        UsersMap usersMap = reader.toObject("users.yml", UsersMap.class);
        usersMap.getUsers().forEach((k, v) -> System.out.printf("Key: %s, values: %s\n", k, v));
    }
}
