package com.courses.parking;

/**
 * Created by Kate on 31.05.2017
 */
public abstract class Vehicle {
    private Integer time;
    private String carPlate;


    public abstract Double getPrice(double basePrice);

    public Vehicle(Integer time, String carPlate) {
        this.time = time;
        this.carPlate = carPlate;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public Integer getTime() {
        return time;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "time=" + time +
                ", carPlate='" + carPlate + '\'' +
                '}';
    }
}
