package com.courses.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate on 31.05.2017
 */
public class Parking {
    private int size;
    private double basePrice;
    private List<Vehicle> vehicleList;

    public Parking(int size, double basePrice) {
        this.size = size;
        this.basePrice = basePrice;
        vehicleList = new ArrayList<>(size);
    }

    private void addVehicle(Vehicle vehicle) {
        System.out.println("Ставим на парковку: " + vehicle);
        if (vehicleList.size() < size) {
            vehicleList.add(vehicle);
            System.out.println("Стоимость парковки: " + vehicle.getPrice(basePrice));
        } else System.out.println("Мест нет");
    }

    private void removeVehicle(Vehicle vehicle) {
        if (vehicleList != null) {
            vehicleList.remove(vehicle);
        } else System.out.println("Парковка пуста");
    }

    private Vehicle findByPlate(String carPlate) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getCarPlate().equals(carPlate)) {
                System.out.println("Машина найдена - " + vehicle);
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "size=" + size +
                ", basePrice=" + basePrice +
                ", vehicleList=" + vehicleList +
                '}';
    }

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
