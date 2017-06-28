package com.courses.week5.jdbc.dao.impl;


import com.courses.week5.jdbc.entity.Movie;
import com.courses.week5.jdbc.exception.DataAccessException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao extends AbstractDao<Movie, Long> {

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM movies";
    }

    @Override
    protected String getIdSelectQuery() {
        return "SELECT * FROM movies WHERE movie_id = ? ";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTo movies VALUES(?, ?,?,?)";
    }

    @Override
    protected List<Movie> convertToEntities(ResultSet resultSet) {
        List<Movie> movies = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int mID = resultSet.getInt("mID");
                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                int year = resultSet.getInt("year");

                movies.add(new Movie(mID, title, year, director));
            }
            return movies;
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Movie movie) {

        try {
            statement.setLong(1, movie.getId());
            statement.setString(2, movie.getTitle());
            statement.setLong(3, movie.getYear());
            statement.setString(4, movie.getDirector());
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public void deleteEntity(Movie entity) {

    }

    @Override
    public Movie updateEntity(Movie entity) {
        return null;
    }
}