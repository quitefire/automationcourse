package com.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtv on 02.06.2017.
 */
public class Parking {

    private List <Vehicle> transports = new ArrayList<>(PARKING_SIZE);
    private boolean isOpen;
    private static final int PARKING_SIZE = 10;

    public Parking() {
        fillTransports();
    }

    private void fillTransports(){
        for (int i = 0; i < PARKING_SIZE ; i++) {
            transports.add(null);
        }
    }

    public boolean addMotoOnLastFreePlace (Vehicle v){
        if(!isOpen) return false;
        int lastMoto =0;
        for(Vehicle item : transports) {
            if (item == null) {
                lastMoto = transports.lastIndexOf(item);
            }
        }
        transports.set(lastMoto,v);
        return true;
    }
    public Vehicle takeLastMoto ( ){
        if(!isOpen) return null;
        int lastMoto =0;
        for(Vehicle item : transports) {
            if (item != null) {
                lastMoto = transports.lastIndexOf(item);
            }
        }
        System.out.println(lastMoto);
        System.out.println(transports.get(lastMoto));
        return transports.get(lastMoto);
    }

    public boolean addMotoByPlaceNumber (int index, Vehicle v){
        if(!isOpen) return false;
        if(transports.get(index) == null){
            transports.set(index,v);
            return true;
        }
        return false;
    }
    public Vehicle takeMotoByPlaceNumber (int index){
        if(!isOpen) return null;
        Vehicle v = null;
        if(transports.get(index) != null){
            v = transports.get(index);
            transports.set(index,null);
        }
        return v;
    }
    public void clearGaragePlaces (){
        if(!isOpen)
        transports.clear();
    }
    public boolean open(){
        return isOpen = true;
    }
    public boolean close (){
        return isOpen = false;
    }
    public Vehicle changeAddress (int index, int changeIndex, Vehicle v){
        if(!isOpen)return null;
        transports.set(index,null);
        transports.set(changeIndex,v);
        return transports.get(changeIndex);
    }
    public void showAllInGarage(){
        if (isOpen) {
            for (Vehicle item : transports) {
                System.out.println(item);
            }
        }

    }

    public boolean addVehicle(Vehicle vehicle){
        if(!isOpen) return false;

        for (int i = 0; i < PARKING_SIZE; i++) {
            if ((transports.get(i)) == null){
                transports.set(i,vehicle);
                break;
            }
        }
        return true;
    }

    public List<Vehicle> getTransports() {
        return transports;
    }

   public void setTransports() {

        this.transports = transports;
   }

}
