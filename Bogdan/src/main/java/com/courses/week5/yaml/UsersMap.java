package com.courses.week5.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableMap;
import lombok.Data;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Data
public class UsersMap {

    private Map<Type, List<User>> users = new EnumMap<>(Type.class);

    public enum Type {
        @JsonProperty("valid")VALID,
        @JsonProperty("invalid")INVALID;
    }
}


