package com.demo.enums;

public enum City {
    LDN("London", "GB");

    private final String city;
    private final String coutryCode;

    City(String city, String coutryCode) {

        this.city = city;
        this.coutryCode = coutryCode;
    }

    public String getCity() {
        return city;
    }

    public String getCoutryCode() {
        return coutryCode;
    }
}
