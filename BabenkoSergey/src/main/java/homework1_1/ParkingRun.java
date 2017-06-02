package homework1_1;

import homework1_1.customexception.ParkingClosedException;

/**
 * Created by Serhii Babenko on 30.05.2017.
 */
public class ParkingRun {
    public static void main(String[] args)  {
        Parking m = new Parking();
         m.close();
         m.open();
        System.out.println("||||| Show all parking places |||||");
        m.printAllPlaces();

        System.out.println();
        System.out.println("||||| Added moto on last free place |||||");
        Vehicle vehicleMoto = new Motorcycle("Java", "AA1015DD");
        m.addVehicleOnLastFreePlace(vehicleMoto);
        m.printAllPlaces();

        System.out.println();
        System.out.println("||||| Added car by place number |||||");
        Vehicle vehicleCar = new Car("Opel Astra", "AA4012BB");
        m.addVehicleByPlaceNumber(vehicleCar, 8);
        m.printAllPlaces();


        System.out.println();
        System.out.println("||||| Remove Car from Place |||||");
        m.removeVehicleFromPlace(8);
        m.printAllPlaces();

        System.out.println();
        System.out.println("||||| Move moto from 0 to 7 e |||||");
        m.changeAddress(0,7);
        m.printAllPlaces();


        System.out.println();
        System.out.println("||||| Take Last Vehicle|||||");
        System.out.println(m.takeLastVehicle());

        System.out.println();
        System.out.println("||||| Take Vehicle by Place number|||||");
        System.out.println(m.takeVehicleByPlaceNumber(7));


    }
}
