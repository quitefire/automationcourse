package com.courses.week5.jdbi_example;

import com.courses.week5.jdbi_example.entity.Movie;
import com.courses.week5.jdbi_example.dao.MovieDao;
import com.courses.week5.jdbi_example.mappers.MovieMapper;
import com.courses.week5.jdbi_example.utils.DBConfig;
import org.aeonbits.owner.ConfigFactory;
import org.skife.jdbi.v2.DBI;

import java.util.List;


// see http://jdbi.org
public class JDBIExample {

    public static void main(String[] args) {
        DBConfig dbConfig = ConfigFactory.create(DBConfig.class);
        DBI dbi = new DBI(dbConfig.jdbcUrl(), dbConfig.user(), dbConfig.password());
        List<Movie> movies = dbi.withHandle(
                handle -> handle.createQuery("select * from movies").
                        map(new MovieMapper()).
                        list());
        movies.forEach(System.out::println);


        // dao example
        MovieDao dao = dbi.onDemand(MovieDao.class);
        Movie movie = dao.findMovieByDirector("Victor Fleming");
        List<Movie> movies1 = dao.findAll();
        System.out.println(movies1);
        long save = dao.save(new Movie("Inserted Movie", 2018, "unknown director"));
        List<Movie> movies2 = dao.findAll();
        System.out.println(movies2);
    }
}
