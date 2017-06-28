package com.courses.week5.jdbc.utils;

import com.courses.week5.jdbi_example.utils.DBConfig;
import org.aeonbits.owner.ConfigFactory;

import java.sql.*;


public class JdbcUtils {

    private static DBConfig dbConfig = ConfigFactory.create(DBConfig.class);

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbConfig.jdbcUrl(), dbConfig.user(), dbConfig.password());
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}