package com.courses.parking;

/**
 * Created by Kate on 06.06.2017.
 */
public class ParkigMain {
    public static void main(String[] args) {

        Parking parking = new Parking(3,2);

        Vehicle vehicle = new Motorbike(1,"123");
        Vehicle vehicle1 = new Car(2,"1234");
        Vehicle vehicle2 = new Bus(12,"98");
        Vehicle vehicle3 = new Car(1,"13");
        System.out.println(parking);
        parking.addVehicle(vehicle);
        parking.addVehicle(vehicle1);
        parking.addVehicle(vehicle2);
        parking.addVehicle(vehicle3);
        System.out.println(parking);

        parking.removeVehicle(parking.findByPlate("1234"));

        System.out.println(parking);
    }
}
