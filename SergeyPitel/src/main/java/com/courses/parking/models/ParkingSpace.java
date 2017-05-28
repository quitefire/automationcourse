package com.courses.parking.models;


/**
 * This class represents single parking space
 */

public class ParkingSpace {

    private int number;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpace(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
    }

    /**
     * @param vehicle is a vehicle to add
     * @return true if vehicle successfully added
     */
    public boolean putVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new NullPointerException();
        this.vehicle = vehicle;
        isFree = false;
        return true;
    }

    /**
     * @return true if vehicle successfully removed
     */
    public boolean removeVehicle() {
        if (vehicle != null) {
            vehicle = null;
            isFree = true;
            return true;
        }
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean checkIfFree() {
        return isFree;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "number=" + number +
                ", isFree=" + isFree +
                ", vehicle=" + vehicle +
                '}' + "\n";
    }
}
