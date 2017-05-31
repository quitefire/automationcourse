package homework1_1;

import homework1_1.customexception.ParkingClosedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public class Parking {

    private List<ParkingPlace> parkingPlacesList;
    private static final int DEFAULT_PARKING_SIZE = 10;
    boolean isClosed;

    public Parking() {
        parkingPlacesList = new ArrayList<>(DEFAULT_PARKING_SIZE);
        populateParkingPlace();
    }

    public void populateParkingPlace() {
        for (int i = 0; i < DEFAULT_PARKING_SIZE; i++) {
            parkingPlacesList.add(new ParkingPlace(i, true, null));
        }
    }

    public void printAllPlaces() {
        for (ParkingPlace place : parkingPlacesList) {
            System.out.println(place);
        }

    }

    public boolean addVehicleOnLastFreePlace(Vehicle vehicle) {
        if (isClosed) return false;
        for (ParkingPlace place : parkingPlacesList) {
            if (place.isFree()) {
                place.setVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void showAllBusyPlaces() {
        for (ParkingPlace place : parkingPlacesList) {
            if (!place.isFree()) {
                System.out.println(place);
            }
        }
    }

    public void showAllFreePlaces() {
        for (ParkingPlace place : parkingPlacesList) {
            if (place.isFree()) {
                System.out.println(place);
            }
        }
    }

    public Vehicle takeLastVehicle() {
        if (isClosed) return null;
        for (int i = DEFAULT_PARKING_SIZE - 1; i >= 0; i--) {
            if (!(parkingPlacesList.get(i).isFree())) return parkingPlacesList.get(i).getVehicle();
        }
        return null;
    }

    public boolean addVehicleByPlaceNumber(Vehicle vehicle, int placeNumber) {
        if (isClosed) return false;
        if (placeNumber <= DEFAULT_PARKING_SIZE && parkingPlacesList.get(placeNumber).isFree()) {
            ParkingPlace item = parkingPlacesList.get(placeNumber);
            item.setVehicle(vehicle);
            parkingPlacesList.set(placeNumber, item);
            return true;
        }
        return false;
    }

    public Vehicle takeVehicleByPlaceNumber(int placeNumber) {
        if (isClosed) return null;
        if (placeNumber <= DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(placeNumber).isFree()))
            return parkingPlacesList.get(placeNumber).getVehicle();
        return null;
    }

    public void open() {
        isClosed = false;
    }

    public void close() {
        isClosed = true;
    }

    public boolean removeVehicleFromPlace(int placeNumber) {
        if (isClosed) return false;
        if (placeNumber <= DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(placeNumber).isFree())) {
            parkingPlacesList.get(placeNumber).setPlaceFree();
            return true;
        }
        return false;
    }


    public boolean changeAddress(int oldPlaceNumber, int newPlaceNumber) {
        if (isClosed) return false;
        if (oldPlaceNumber <= DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(oldPlaceNumber).isFree()) &&
                newPlaceNumber <= DEFAULT_PARKING_SIZE && parkingPlacesList.get(newPlaceNumber).isFree()) {
            addVehicleByPlaceNumber(parkingPlacesList.get(oldPlaceNumber).getVehicle(), newPlaceNumber);
            parkingPlacesList.get(oldPlaceNumber).setPlaceFree();
            return true;
        }
        return false;
    }

}
