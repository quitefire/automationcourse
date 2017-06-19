package com.courses.week5.yaml;

import java.util.List;

import static com.courses.week5.yaml.UsersMap.Type.INVALID;

public class YamlReaderRun {

    public static void main(String[] args) {

        YamlReader reader = new YamlReader();
        UsersMap usersMap = reader.toObject("user.yml", UsersMap.class);

        usersMap.getUsers().forEach((k, v) -> System.out.printf("Key: %s, values: %s\n", k, v));

        List<User> users = usersMap.getUsers().get(INVALID);
        users.forEach(System.out::println);
    }
}
