package com.courses.week5.jdbi_example.dao;

import com.courses.week5.jdbi_example.entity.Movie;
import com.courses.week5.jdbi_example.mappers.MovieMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(MovieMapper.class)
public interface MovieDao {

    @SqlQuery("select * from movies where director = :director")
    Movie findMovieByDirector(@Bind("director") String director);

    @SqlQuery("select * from movies")
    List<Movie> findAll();


    @SqlUpdate("INSERT INTO movies(title,year,director) VALUES (:movie.title,:movie.year,:movie.director)")
    long save(@BindBean("movie") Movie movie);

}