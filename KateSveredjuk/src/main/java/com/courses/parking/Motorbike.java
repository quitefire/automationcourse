package com.courses.parking;

/**
 * Created by Kate on 31.05.2017.
 */
public class Motorbike extends Vehicle {


    public Motorbike(Integer time, String carPlate) {
        super(time, carPlate);
    }

    @Override
    public Double getPrice(double basePrice) {

        return basePrice * 0.5 * getTime();
    }
}
