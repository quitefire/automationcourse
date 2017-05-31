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

    public void populateParkingPlace(){
        for (int i = 0; i < DEFAULT_PARKING_SIZE; i++) {
            parkingPlacesList.add(new ParkingPlace(i, true, null));
        }
    }

    public boolean printAllPlaces() {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to show all places. Parking is closed");
            return false;
        }

        for (ParkingPlace place: parkingPlacesList) {
            System.out.println(place);
        }
        return true;
    }

    public boolean addVehicleOnLastFreePlace(Vehicle vehicle) {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to add Vehicle to last free place. Parking is closed");
        }
        for (ParkingPlace place: parkingPlacesList) {
            if (place.isFree()){
                place.setVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void showAllBusyPlaces(){
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to show all busy places. Parking is closed");
        }
        for (ParkingPlace place: parkingPlacesList) {
            if (!place.isFree()){
                System.out.println(place);
            }
        }

    }

    public void showAllFreePlaces() {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to show all free places. Parking is closed");
        }
        for (ParkingPlace place: parkingPlacesList) {
            if (place.isFree()){
                System.out.println(place);
            }
        }
    }



    public Vehicle takeLastVehicle() {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            System.out.println("Unable to take last Vehicle. Parking is closed");
        }
        for (int i = DEFAULT_PARKING_SIZE-1; i >= 0; i--) {
            if(!(parkingPlacesList.get(i).isFree())) return parkingPlacesList.get(i).getVehicle();
        }
        return null;
    }

    public boolean addVehicleByPlaceNumber(Vehicle vehicle, int placeNumber) {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to add Vehicle. Parking is closed");
        }
        if(placeNumber<=DEFAULT_PARKING_SIZE && parkingPlacesList.get(placeNumber).isFree()){
            ParkingPlace item = parkingPlacesList.get(placeNumber);
            item.setVehicle(vehicle);
            parkingPlacesList.set(placeNumber, item);
            return true;
        }
        return false;
    }

    public Vehicle takeVehicleByPlaceNumber(int placeNumber){
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to take Vehicle. Parking is closed");
        }
        if (placeNumber<=DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(placeNumber).isFree()))
            return parkingPlacesList.get(placeNumber).getVehicle();

        return null;
    }
    public void open(){
        isClosed = false;
    }
    public void close(){
        isClosed = true;
    }
    public boolean removeVehicleFromPlace(int placeNumber) {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to remove Vehicle. Parking is closed");
        }
        if (placeNumber<=DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(placeNumber).isFree())){
            parkingPlacesList.get(placeNumber).setPlaceFree();
            return true;
        }
            return false;
    }


    public boolean changeAddress(int oldPlaceNumber, int newPlaceNumber) {
        if (isClosed) try {
            throw new ParkingClosedException("Parking is cosed");
        } catch (ParkingClosedException e) {
            //e.printStackTrace();
            System.out.println("Unable to change Vehicle place. Parking is closed");
        }
        if (oldPlaceNumber<=DEFAULT_PARKING_SIZE && !(parkingPlacesList.get(oldPlaceNumber).isFree()) &&
                newPlaceNumber<=DEFAULT_PARKING_SIZE && parkingPlacesList.get(newPlaceNumber).isFree()){
            addVehicleByPlaceNumber(parkingPlacesList.get(oldPlaceNumber).getVehicle(), newPlaceNumber);
            parkingPlacesList.get(oldPlaceNumber).setPlaceFree();
            return true;
        }
        return false;
    }

}
