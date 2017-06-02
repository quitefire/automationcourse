package com.courses.parking;

public class Car extends Vehicle{

	public Car(String make, String model, String plateNumber) {
		super(make, model, plateNumber);
		mType = "car";
	}
}
