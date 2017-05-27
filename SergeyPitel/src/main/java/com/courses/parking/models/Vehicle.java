package com.courses.parking.models;

/**
 * Created by sergoneeight on 5/25/17.
 */
public abstract class Vehicle {

    private String model;
    private String plateNumber;

    public Vehicle(String model, String plateNumber) {
        this.model = model;
        this.plateNumber = plateNumber;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                "}";

    }
}
