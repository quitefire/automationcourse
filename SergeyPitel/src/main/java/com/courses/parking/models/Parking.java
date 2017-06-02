package com.courses.parking.models;

import com.courses.parking.exceptions.InvalidPlaceNumberException;
import com.courses.parking.exceptions.ParkingClosedException;

import java.util.ArrayList;
import java.util.List;


public class Parking {

    private String address;
    private boolean isOpened;
    private int parkingSpacesAmount;
    private List<ParkingSpace> parkingSpaces;

    public Parking(int parkingLotsAmount) {
        this.parkingSpacesAmount = parkingLotsAmount;
        initializeParkingSpaces();
    }

    /**
     * Puts vehicle into free parking space
     *
     * @param vehicle is a vehicle to add
     * @return true if vehicle successfully added
     */
    public boolean addVehicleToFreeParkingSpace(Vehicle vehicle) {
        if (vehicle == null) return false;

        if (!isOpened) {
            throw new ParkingClosedException("Sorry parking is closed. Come back later");
        }

        ParkingSpace parkingSpace = findFreeParkingSpace();
        return parkingSpace != null && parkingSpace.putVehicle(vehicle);
    }

    /**
     * Puts vehicle into chosen parking space
     *
     * @param vehicle     is a vehicle to add
     * @param placeNumber is number of parking place
     * @return true if vehicle successfully added
     */
    public boolean addVehicleByPlaceNumber(Vehicle vehicle, int placeNumber) {
        if (!isOpened) {
            throw new ParkingClosedException("Sorry parking is closed. Come back later");
        }

        if (!checkIfPlaceNumberValid(placeNumber)) {
            throw new InvalidPlaceNumberException("Parking place number: " + placeNumber + "does not exist");
        }

        if (parkingSpaces.get(placeNumber).checkIfFree()) {
            return parkingSpaces.get(placeNumber).putVehicle(vehicle);
        }
        return false;
    }


    public Vehicle takeVehicleByPlaceNumber(int placeNumber) {
        if (!isOpened) {
            throw new ParkingClosedException("Sorry parking is closed. Come back later");
        }

        if (!checkIfPlaceNumberValid(placeNumber)) {
            throw new InvalidPlaceNumberException("Parking place number: " + placeNumber + "does not exist");
        }

        return parkingSpaces.get(placeNumber).getVehicle();
    }


    /**
     * Removes vehicle from each parking space
     */
    public void clearAllParkingSpaces() {
        for (ParkingSpace parkingSpace : parkingSpaces) {
            parkingSpace.removeVehicle();
        }
    }

    /**
     * Removes vehicle from chosen parking place
     *
     * @param placeNumber is number of parking place
     * @return true if vehicle successfully removed
     */
    public boolean clearParkingSpaceByPlaceNumber(int placeNumber) {
        return parkingSpaces.get(placeNumber).removeVehicle();
    }


    /**
     * @return free Parking space if available
     */
    public ParkingSpace findFreeParkingSpace() {
        ParkingSpace freeParkingSpace = null;

        for (ParkingSpace p : parkingSpaces) {
            if (p.checkIfFree()) {
                freeParkingSpace = p;
                break;
            }
        }
        return freeParkingSpace;
    }


    /**
     * Initialize parkingSpaces List with selected amount of parking places
     */
    private void initializeParkingSpaces() {
        parkingSpaces = new ArrayList<>();
        for (int i = 0; i < parkingSpacesAmount; i++) {
            parkingSpaces.add(new ParkingSpace(i, true));
        }
    }

    private boolean checkIfPlaceNumberValid(int placeNumber) {
        return placeNumber <= parkingSpacesAmount && placeNumber >= 0;
    }

    public void showAllVehiclesInParking() {
        System.out.println(parkingSpaces.toString());
    }

    public void openParking() {
        isOpened = true;
    }

    public void closeParking() {
        isOpened = false;
    }

    public void changeAddres(String newAddress) {
        this.address = newAddress;
    }
}
