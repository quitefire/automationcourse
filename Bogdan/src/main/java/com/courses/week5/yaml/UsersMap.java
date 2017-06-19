package com.courses.week5.yaml;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class UsersMap {

    private Map<Type, List<User>> users = new EnumMap<>(Type.class);

    public Map<Type, List<User>> getUsers() {
        return ImmutableMap.copyOf(users);
    }

    public enum Type {
        VALID, INVALID;

        @JsonValue
        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }
}


