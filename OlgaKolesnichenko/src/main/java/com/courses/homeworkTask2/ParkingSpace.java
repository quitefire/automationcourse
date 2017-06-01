package com.courses.homeworkTask2;

public class ParkingSpace {

    private int placeNumber;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpace(int placeNumber, boolean isFree) {
        this.placeNumber = placeNumber;
        this.isFree = isFree;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new NullPointerException();
        this.vehicle = vehicle;
        isFree = false;
        return true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean removeVehicle() {
        if (vehicle != null) {
            vehicle = null;
            isFree = true;
            return true;
        }
        return false;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "placeNumber=" + placeNumber +
                ", isFree=" + isFree +
                ", vehicle=" + vehicle +
                '}';
    }
}
