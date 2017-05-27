package com.courses.parking.models;

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
     * @return parking space number if successful else -1
     */
    public int addVehicleToFreeParkingSpace(Vehicle vehicle) {

        if (vehicle == null) return -1;

        if (!isOpened) {
            System.out.println("Sorry parking is closed. Come back later");
            return -1;
        }

        ParkingSpace parkingSpace = findFreeParkingSpace();
        if (parkingSpace != null) {
            return parkingSpace.putVehicle(vehicle);
        }

        return -1;
    }

    /**
     * Puts vehicle into chosen parking space
     *
     * @param vehicle     is a vehicle to add
     * @param placeNumber is number of parking place
     * @return parking space number if successful else -1
     */
    public int addVehicleByPlaceNumber(Vehicle vehicle, int placeNumber) {
        if (!isOpened) {
            System.out.println("Sorry parking is closed. Come back later");
            return -1;
        }

        if (!checkIfPlaceNumberValid(placeNumber)) {
            System.out.println("Sorry there is no parking lot with such number. Try another");
            return -1;
        }

        if (parkingSpaces.get(placeNumber).checkIfFree()) {
            return parkingSpaces.get(placeNumber).putVehicle(vehicle);
        } else {
            System.out.println("Sorry parking lot with number: " + placeNumber + " reserved");
            return -1;
        }
    }


    public Vehicle takeVehicleByPlaceNumber(int placeNumber) {
        if (!isOpened) {
            System.out.println("Sorry parking is closed. Come back later");
            return null;
        }

        if (!checkIfPlaceNumberValid(placeNumber)) {
            System.out.println("Sorry there is no parking lot with such number. Try another");
            return null;
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
     * @return parking space number if successful else -1
     */
    public int clearParkingSpaceByPlaceNumber(int placeNumber) {
        return parkingSpaces.get(placeNumber).removeVehicle();
    }


    /**
     * @return free Parking lot if available
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
