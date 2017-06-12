package com.courses.week4.mockito.examples.model;

public enum Country {

    UK("United Kingdom", "UK"),
    NL("Netherlands", "NL");

    private final String name;
    private final String code;

    Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }



}
