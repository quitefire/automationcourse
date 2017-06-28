package com.courses.week5.jdbc.dao.impl;


import com.courses.week5.jdbc.dao.IDao;
import com.courses.week5.jdbc.entity.AbstractEntity;
import com.courses.week5.jdbc.exception.DataAccessException;
import com.courses.week5.jdbc.utils.JdbcUtils;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

public abstract class AbstractDao<E extends AbstractEntity, ID extends Serializable> implements IDao<E, ID> {

    protected abstract String getSelectQuery();

    protected abstract String getIdSelectQuery();

    protected abstract String getInsertQuery();

    protected abstract List<E> convertToEntities(ResultSet resultSet);

    protected abstract void prepareStatementForInsert(PreparedStatement preparedStatement, E object);

    @Override
    public List<E> getAll() {

        final String query = getSelectQuery();

        try (Connection connection = JdbcUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            return convertToEntities(resultSet);
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public E getEntityById(ID id) {

        final String query = getIdSelectQuery();

        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, (Long) id);
            ResultSet resultSet = statement.executeQuery();
            List<E> list = convertToEntities(resultSet);
            return list.size() > 0 ? list.get(0) : null;
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    @Override
    public boolean insertEntity(E entity) {
        final String insertQuery = getInsertQuery();

        Connection connection = null;
        PreparedStatement statement;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement(insertQuery);
            prepareStatementForInsert(statement, entity);
            int insertedRows = statement.executeUpdate();
            return insertedRows > 0;
        } catch (SQLException e) {
            JdbcUtils.rollback(connection);
            throw new DataAccessException(e.getMessage());
        }
    }
}