package com.courses.homeworkTask2;

import com.courses.homeworkTask2.Exceptions.InvalidPalceNumberException;
import com.courses.homeworkTask2.Exceptions.ParkingIsClosedException;
import com.courses.homeworkTask2.Exceptions.PlaceIsTakenException;

import java.util.ArrayList;
import java.util.List;


public class Parking {

    private String address;
    private boolean isOpen = true;
    private int parkingSize = 10;
    private List<ParkingSpace> parkingPlaces;

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        initializeParkingSpaces();
    }

    private void initializeParkingSpaces() {
        parkingPlaces = new ArrayList<>();
        for (int i = 0; i < parkingSize; i++) {
            parkingPlaces.add(new ParkingSpace(i, true));
        }
    }

    /**
     * @param placeNumber
     * @return true if place number is valid
     */
    private boolean isPlaceNumberValid(int placeNumber) {
        return placeNumber <= parkingSize && placeNumber >= 0;
    }

    public boolean addVehicleOnLastFreePlace(Vehicle vehicle) {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        for (ParkingSpace place : parkingPlaces) {
            if (place.isFree()) {
                return place.parkVehicle(vehicle);
            }
        }
        return false;
    }

    public boolean addVehicleByPlaceNumber(int placeNumber, Vehicle vehicle) {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        if (!isPlaceNumberValid(placeNumber)) throw new InvalidPalceNumberException("Only 0-10 places are available ");
        if (parkingPlaces.get(placeNumber).isFree()) {
            return parkingPlaces.get(placeNumber).parkVehicle(vehicle);
        } else throw new PlaceIsTakenException("Place " + placeNumber + " is taken");
    }

    public Vehicle takeVehicleByPlaceNumber(int placeNumber) {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        if (!isPlaceNumberValid(placeNumber)) throw new InvalidPalceNumberException("Only 0-10 places are available ");
        return parkingPlaces.get(placeNumber).getVehicle();
    }

    public Vehicle takeLastVehicle() {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        System.out.println("Last place:");
        for (int i = parkingSize - 1; i >= 0; i--) {
            if (!(parkingPlaces.get(i).isFree())) return parkingPlaces.get(i).getVehicle();
        }
        return null;
    }

    public void showAllInGarage() {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        System.out.println("All Vehicles in garage::");
        for (ParkingSpace space : parkingPlaces) {
            if (!space.isFree())
                System.out.println(space);
        }
    }

    public boolean clearGaragePlaceByNumber(int placeNumber) {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        if (!isPlaceNumberValid(placeNumber)) throw new InvalidPalceNumberException("Only 0-10 places are available ");
        if (!parkingPlaces.get(placeNumber).isFree())
            return parkingPlaces.get(placeNumber).removeVehicle();
        else System.out.println("Place is free!");
        return false;
    }

    public void clearAllGaragePlaces() {
        if (!isOpen) throw new ParkingIsClosedException("Parking is closed!");
        for (ParkingSpace space : parkingPlaces)
            space.removeVehicle();
        System.out.println("All places are free!");
    }

    public void open() {
        isOpen = true;
        System.out.println("Parking is open!");
    }

    public void close() {
        if (!isOpen) throw new ParkingIsClosedException("Parking is already closed!");
        isOpen = false;
        System.out.println("Parking os closed!");
    }

    public void changeAddress(String address) {
        this.address = address;
    }
}