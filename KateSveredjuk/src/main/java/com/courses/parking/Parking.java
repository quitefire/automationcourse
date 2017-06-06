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

    public void addVehicle(Vehicle vehicle) {
        System.out.println("Ставим на парковку: " + vehicle);
        if (vehicleList.size() < size) {
            vehicleList.add(vehicle);
            System.out.println("Стоимость парковки: " + vehicle.getPrice(basePrice));
        } else System.out.println("Мест нет");
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicleList != null) {
            vehicleList.remove(vehicle);
        } else System.out.println("Парковка пуста");
    }

    public Vehicle findByPlate(String carPlate) {
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


}
