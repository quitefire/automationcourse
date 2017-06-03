package com.parking;

/**
 * Created by dtv on 02.06.2017.
 */
public class ParkingRun {
    public static void main(String[] args) {
        Parking testParking = new Parking();
        //testParking.setTransports();
       // testParking.getTransports();






         //adding vehicle to  parking
        Car c1 = new Car("LADA","aa33366aa");
        Car c2 = new Car("KIA","aa33377aa");
        Car c3 = new Car("OPEL","aa3322aa");
        Car c4 = new Car("BMW","aa33344aa");


        Moto m1 = new Moto("HONDA","aa6655aa");
        Moto m2 = new Moto("SUZUKI","aa6855aa");
        Moto m3 = new Moto("KAWASAKI","aa6755aa");
        Moto m4 = new Moto("YAMAHA","aa6955aa");

        testParking.showAllInGarage();

        System.out.println();
        System.out.println();


        testParking.open();
        testParking.addVehicle(m1);
        testParking.addVehicle(m2);
        testParking.addVehicle(m3);
        testParking.addMotoByPlaceNumber(7,m4);
        testParking.changeAddress(7,9,m4);
        testParking.takeLastMoto();
        //testParking.clearGaragePlaces();



        System.out.println("AAAAAAAAAAAAAAAA");
        testParking.showAllInGarage();
        System.out.println();
        System.out.println();



        //testParking.close();
        testParking.addVehicle(c1);
        testParking.addVehicle(c2);
        testParking.addVehicle(c3);
        testParking.addVehicle(c4);
        testParking.showAllInGarage();


    }
}
