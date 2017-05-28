package com.courses.parking;

import com.github.javafaker.Faker;

public class ParkingRun {

	public static void main(String[] args) {

		Faker faker = new Faker();

		Parking parking = new Parking(5);
		parking.printAvailable();

		// test addMotoOnLastFreePlace

		Vehicle moto1 = new Motorcycle(faker.company().name(), faker.company().buzzword(), faker.idNumber().valid());
		parking.checkIn(moto1);
		parking.printAvailable();

		// test addMotoByPlaceNumber

		Vehicle moto2 = new Motorcycle(faker.company().name(), faker.company().buzzword(), faker.idNumber().valid());
		parking.checkIn(moto2, 2);
		parking.printAvailable();

		// test takeLastMoto - task is unclear (moto on last place or last added).

		// test takeMotoByPlaceNumber
		parking.checkOut(1);
		parking.printAvailable();

		// test clearGaragePlaces

		parking.clear();
		parking.printAvailable();

		// test can not open already open parking

		parking.open();

		// test close

		parking.close();

		// test can not check-in vehicle in closed parking

		Vehicle moto = new Motorcycle(faker.company().name(), faker.company().buzzword(), faker.idNumber().valid());
		parking.checkIn(moto);
		parking.printAvailable();

		// test open

		parking.open();

		// showAllInGarage

		parking.printAllVehicles();

		parking.checkIn(moto1);
		parking.checkIn(moto2, 6);

		parking.printAllVehicles();

		// test changeAddress
		System.out.println(parking);
		parking.setAddress(faker.address().streetAddress());
		System.out.println(parking);





	}





}
