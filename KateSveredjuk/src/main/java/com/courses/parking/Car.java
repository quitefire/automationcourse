package com.courses.parking;

/**
 * Created by Kate on 31.05.2017.
 */
public class Car extends Vehicle {

    public Car(Integer time, String carPlate) {
        super(time, carPlate);
    }

    @Override
    public Double getPrice(double basePrice) {
        return basePrice*1*getTime();
    }
}
