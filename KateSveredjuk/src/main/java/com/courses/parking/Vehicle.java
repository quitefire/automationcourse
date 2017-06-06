package com.courses.parking;

/**
 * Created by Kate on 31.05.2017
 */
public abstract class Vehicle {
    private Integer time;
    private String carPlate;

    public Vehicle(Integer time, String carPlate) {
        if (time <= 0) {
            throw new IllegalArgumentException("Time less than zero");
        }
        if (carPlate == null){
            throw new IllegalArgumentException("Car plate is null");
        }

        this.time = time;
        this.carPlate = carPlate;

    }

    public abstract Double getPrice(double basePrice);

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
