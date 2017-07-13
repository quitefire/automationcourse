package com.parking;

/**
 * Created by dtv on 02.06.2017.
 */
public abstract class Vehicle {
    private String model;
    private String plateNumber;

    protected Vehicle(String model, String plateNumber){
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
    public  String toString() {
        return "Model: " + model + ":Plate Number: " + plateNumber;
    }
}
