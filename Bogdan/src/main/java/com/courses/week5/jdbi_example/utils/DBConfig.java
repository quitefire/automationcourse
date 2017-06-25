package com.courses.week5.jdbi_example.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:db.properties"})
public interface DBConfig extends Config {

    @Key("jdbc.url")
    String jdbcUrl();

    String user();

    String password();
}
