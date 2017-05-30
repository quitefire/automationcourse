package homework1_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public class Parking {
    public class ParkingClosedException extends Exception {
        public ParkingClosedException(String message) {
            super(message);
        }
    }
    private List<ParkingPlace> parkingPlacesList;
    int PLACECOUNT = 10;
    boolean isParkingClosed = false;

    public Parking() {
        parkingPlacesList = new ArrayList<>(PLACECOUNT);

        for (int i = 0; i < PLACECOUNT; i++) {
            parkingPlacesList.add(new ParkingPlace(i, true, null));
        }
    }

    public void printAllPlaces() {
        for (ParkingPlace place: parkingPlacesList) {
            System.out.println(place);
        }
    }

    public void addVehicleOnLastFreePlace(Vehicle vehicle) throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        for (ParkingPlace place: parkingPlacesList) {
            if (place.isFree()){
                place.setVehicle(vehicle);
                break;
            }
        }
    }

    public void showAllBusyPlaces() throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        for (ParkingPlace place: parkingPlacesList) {
            if (!place.isFree()){
                System.out.println(place);
            }
        }

    }

    public void showAllFreePlaces() throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        for (ParkingPlace place: parkingPlacesList) {
            if (place.isFree()){
                System.out.println(place);
            }
        }
    }



    public void takeLastVehicle() throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        for (int i = PLACECOUNT; i >= 0; i--) {
            if(!parkingPlacesList.get(i).isFree()){
                System.out.println(parkingPlacesList.get(i));
                break;
            }
        }
    }

    public void addVehicleByPlaceNumber(Vehicle vehicle, int placeNumber) throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        if(placeNumber<=PLACECOUNT && parkingPlacesList.get(placeNumber).isFree()){
            ParkingPlace item = parkingPlacesList.get(placeNumber);
            item.setVehicle(vehicle);
            parkingPlacesList.set(placeNumber, item);
        }
    }

    public Vehicle takeVehicleByPlaceNumber(int placeNumber) throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        if (placeNumber<=PLACECOUNT && !(parkingPlacesList.get(placeNumber).isFree()))
            return parkingPlacesList.get(placeNumber).getVehicle();

        return null;
    }
    public void open(){
        isParkingClosed = false;
    }
    public void close(){
        isParkingClosed = true;
    }
    public void removeVehicleFromPlace(int placeNumber) throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        if (placeNumber<=PLACECOUNT && !(parkingPlacesList.get(placeNumber).isFree()))
            parkingPlacesList.get(placeNumber).setPlaceFree();
    }


    public void changeAddress(int oldPlaceNumber, int newPlaceNumber) throws ParkingClosedException {
        if (isParkingClosed) throw new ParkingClosedException("Parking is cosed");
        if (oldPlaceNumber<=PLACECOUNT && !(parkingPlacesList.get(oldPlaceNumber).isFree()) && newPlaceNumber<=PLACECOUNT && parkingPlacesList.get(newPlaceNumber).isFree()){
            addVehicleByPlaceNumber(parkingPlacesList.get(oldPlaceNumber).getVehicle(), newPlaceNumber);
            parkingPlacesList.get(oldPlaceNumber).setPlaceFree();
        }

    }




   /* - addMotoOnLastFreePlace
    - takeLastMoto
    - addMotoByPlaceNumber
    - takeMotoByPlaceNumber
    - clearGaragePlaces
    - open
    - close
    - changeAddress
    - showAllInGarage
    */

}
