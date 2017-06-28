package com.courses.week5.jdbc;


import com.courses.week5.jdbc.dao.IDao;
import com.courses.week5.jdbc.dao.impl.MovieDao;
import com.courses.week5.jdbc.entity.Movie;

import java.util.List;

public class DaoRun {

    public static void main(String[] args) {
        IDao<Movie, Long> movieDao = new MovieDao();
        List<Movie> movies1 = movieDao.getAll();
        movies1.forEach(System.out::println);
        // movieDao.insertEntity(new Movie(200, "my title", 1939, "my author"));
        System.out.println("after insert");
        List<Movie> movies2 = movieDao.getAll();
        movies2.forEach(System.out::println);

    }
}
