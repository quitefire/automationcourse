package com.courses.week5.jdbc.dao;

import com.courses.week5.jdbc.entity.AbstractEntity;

import java.io.Serializable;
import java.util.List;

public interface IDao<E extends AbstractEntity, ID extends Serializable> {

    List<E> getAll();

    E getEntityById(ID id);

    boolean insertEntity(E entity);

    void deleteEntity(E entity);

    E updateEntity(E entity);
}