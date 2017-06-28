package com.courses.week5.jdbc.entity;

public abstract class AbstractEntity {

    protected long id;

    public AbstractEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}