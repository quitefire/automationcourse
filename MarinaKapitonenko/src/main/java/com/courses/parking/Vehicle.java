package com.courses.parking;

public class Vehicle {
	protected String mMake;
	protected String mModel;
	protected String mPlateNumber;
	protected String mType;

	public Vehicle(String make, String model, String plateNumber) {
		mMake = make;
		mModel = model;
		mPlateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return "The " + mType + " " + mMake + " " + mModel + " number " + mPlateNumber;
	}
}
