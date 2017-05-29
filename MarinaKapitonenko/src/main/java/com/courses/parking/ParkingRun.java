package com.courses.parking;

import com.github.javafaker.Faker;

public class ParkingRun {

	public static Faker sFaker = new Faker();
	public static void main(String[] args) {

		Parking parking = new Parking(5);

		// test addMotoOnLastFreePlace
		System.out.println("--- test addMotoOnLastFreePlace ---");

		Vehicle moto1 = getVehicleFixture("moto");
		parking.checkIn(moto1);
		parking.printAvailable();

		// test addMotoByPlaceNumber
		System.out.println("--- test addMotoByPlaceNumber ---");

		Vehicle moto2 = getVehicleFixture("moto");
		parking.checkIn(moto2, 4);
		parking.printAvailable();

		// test takeLastMoto - task is unclear (moto on last place or last added).

		// test takeMotoByPlaceNumber
		System.out.println("--- test takeMotoByPlaceNumber ---");

		parking.checkOut(4);
		parking.printAvailable();

		// test clearGaragePlaces
		System.out.println("--- test test clearGaragePlaces ---");

		parking.clearAll();
		parking.printAvailable();

		// test can not open already open parking
		System.out.println("--- test can not open already open parking ---");

		parking.open();

		// test close
		System.out.println("--- test close ---");

		parking.close();

		// test can not check-in vehicle in closed parking
		System.out.println("--- test can not check-in vehicle in closed parking ---");

		Vehicle moto3 = getVehicleFixture("moto");
		parking.checkIn(moto3);
		parking.printAvailable();

		// test open
		System.out.println("--- test open ---");

		parking.open();

		// showAllInGarage
		System.out.println("--- showAllInGarage ---");

		parking.printAllVehicles();

		parking.checkIn(moto1);
		parking.checkIn(moto2, 6);
		parking.checkIn(getVehicleFixture("car"), 4);

		parking.printAllVehicles();

		// test changeAddress
		System.out.println("--- test changeAddress ---");

		parking.printInfo();
		parking.setAddress(sFaker.address().streetAddress());
		parking.printInfo();

		// test parking gets constructed with all places taken
		System.out.println("--- test parking gets constructed with all places taken ---");

		Vehicle[] vehicles = {
				moto1,
				moto2,
				moto3
		};
		parking = new Parking(vehicles);
		parking.checkIn(moto1);

	}

	private static Vehicle getVehicleFixture(String type){
		String company = sFaker.company().name();
		String model = sFaker.company().buzzword();
		String number = sFaker.idNumber().valid();
		Vehicle vehicle;
		if (type.equals("car")){
			vehicle = new Car(company, model, number);
		} else {
			vehicle = new Motorcycle(company, model, number);
		}
		return vehicle;
	}





}
