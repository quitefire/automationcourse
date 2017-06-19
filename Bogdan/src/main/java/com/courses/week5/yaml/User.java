package com.courses.week5.yaml;

import java.util.List;

public class User {
    private String name;
    private String job;
    private List<String> skills;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", skills=" + skills +
                '}';
    }
}
