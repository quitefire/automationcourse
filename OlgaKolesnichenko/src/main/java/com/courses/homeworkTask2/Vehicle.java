package com.courses.homeworkTask2;

public abstract class Vehicle {

    protected String model;
    protected String plateNumber;

    public Vehicle(String type, String plateNumber) {
        this.model = type;
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }

}
