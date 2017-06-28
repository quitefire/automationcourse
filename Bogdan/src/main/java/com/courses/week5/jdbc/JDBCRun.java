package com.courses.week5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCRun {


    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private static final String QUERY = "SELECT * FROM movies";

    public static void main(String[] args) {


        //List<Movie> movies = new ArrayList<>();
//
//        Statement statement = null;
//        Connection connection = null;
//
//
//        try {
//            // STEP 1 - create the connection to your DB
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            connection.setAutoCommit(false);
//
//            //STEP 2 - execute the query
//            statement = connection.createStatement();
//
//            //STEP 3 - extract the result from the result set
//            ResultSet resultSet = statement.executeQuery(QUERY);
//
//            while (resultSet.next()) {
//                //current row
//                int mID = resultSet.getInt("mID");
//                String title = resultSet.getString("title");
//                String director = resultSet.getString("director");
//
//                System.out.println("mID:" + mID + "title" + title);
//                Movie movie = new Movie(mID, title);
//                movies.add(movie);
//            }
//
//
//        } catch (SQLException e) {
//            System.err.print(e.getMessage());
//
//        } finally {
//            //finally block used to close resources
//            try {
//                if (statement != null) statement.close();
//            } catch (SQLException e) {
//                System.err.print(e.getMessage());
//            }
//            try {
//                if (connection != null) connection.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        System.out.println(movies);
//        System.out.println(movies.size());


        //try with resources:
        // create a sql query with "?" placeholder
        String updateQuery = "UPDATE movies SET director=? WHERE mID BETWEEN 107 AND 108";

        //open resources with try-with-resources block
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // replace ? with a concrete value
            statement.setString(1, "Serhii");
            // execute prepared query using executeUpdate method ( instead of executeQuery)
            int numberOfUpdatedRows = statement.executeUpdate();

            //numberOfUpdatedRows  - number of records affected by the query
            System.out.println(numberOfUpdatedRows);

        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }
}

