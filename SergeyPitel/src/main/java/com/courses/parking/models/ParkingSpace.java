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
     * @return parking space number if successful else -1
     */
    public int putVehicle(Vehicle vehicle) {
        if (isFree && vehicle != null) {
            this.vehicle = vehicle;
            isFree = false;
            return this.number;
        }
        return -1;
    }

    /**
     * @return parking space number of removed vehicle if successful else -1
     */
    public int removeVehicle() {
        if (vehicle != null) {
            vehicle = null;
            isFree = true;
            return this.number;
        }
        return -1;
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
