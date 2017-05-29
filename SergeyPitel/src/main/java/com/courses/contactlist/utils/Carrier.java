package com.courses.contactlist.utils;


public enum Carrier {

    LIFE("063", "093", "073"),

    KIYVSTAR("067", "068", "096", "098");

    private String[] prefixes;

    Carrier(String... prefix) {
        this.prefixes = prefix;
    }

    public String[] getPrefixes() {
        return prefixes;
    }
}
