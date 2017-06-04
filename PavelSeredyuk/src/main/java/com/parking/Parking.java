package com.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtv on 02.06.2017.
 */
public class Parking {

    private List <Vehicle> transports = new ArrayList<Vehicle>();
    //private Vehicle[] transports = new Vehicle[10];
    private boolean isOpen;
    private static final int DEFAULT_PARKING_SIZE = 10;


    public Parking() {
        List <Vehicle> transports = new ArrayList<Vehicle>(DEFAULT_PARKING_SIZE);
        fillTransports();
    }

    private void fillTransports(){
        for (int i = 0; i < DEFAULT_PARKING_SIZE ; i++) {
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
    public Vehicle takeLastMoto (){
        if(!isOpen) throw new  IllegalStateException("Parking is closed");
        if(transports.isEmpty())return null;
        return transports.get(transports.size()-1);
    }

    public boolean addMotoByPlaceNumber (int index, Vehicle v){
        if(!isOpen) throw new  IllegalStateException("Parking is closed");
        if(transports.get(index) == null){
            transports.set(index,v);
            return true;
        }
        return false;
    }
    public Vehicle takeMotoByPlaceNumber (int index){
        if(!isOpen) throw new  IllegalStateException("Parking is closed");
        Vehicle v = null;
        if(transports.get(index) != null){
            v = transports.get(index);
            transports.set(index,null);
        }
        return v;
    }
    public void clearGaragePlaces (){
        if(isOpen)
        transports.clear();
    }
    public void open(){

        isOpen = true;
    }
    public void close (){

        isOpen = false;
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

//    public boolean addVehicle(Vehicle vehicle){
//        if(!isOpen) throw new  IllegalStateException("Parking is closed");
//
//     for (int i = 0; i < DEFAULT_PARKING_SIZE; i++) {
//           if ((transports.get(i)) == null){
//                transports.set(i,vehicle);
//                break;
//            }
//        }
//
//        transports.add(vehicle);
//        return true;
//    }

    public List<Vehicle> getTransports() {
        return transports;
    }

   public void setTransports() {

        this.transports = transports;
   }

}
