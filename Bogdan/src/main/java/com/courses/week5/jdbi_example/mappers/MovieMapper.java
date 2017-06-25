package com.courses.week5.jdbi_example.mappers;

import com.courses.week5.jdbi_example.entity.Movie;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements ResultSetMapper<Movie> {

    @Override
    public Movie map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
        return new Movie(rs.getLong("mID"), rs.getString("title"), rs.getInt("year"), rs.getString("director"));
    }
}