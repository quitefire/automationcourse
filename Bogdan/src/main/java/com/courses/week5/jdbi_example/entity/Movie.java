package com.courses.week5.jdbi_example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movie {
    private long id;
    private String title;
    private int year;
    private String director;

    public Movie(long id, String title, int year, String director) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }
}
