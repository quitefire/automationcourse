package com.courses.parking;

import java.util.Arrays;

public class Parking {
	private String mAddress;
	private State mOpenState;
	private State mClosedState;

	private State mState;

	private int mCapacity = 10;
	private int mCount = 0;

	private Vehicle[] mVehicles;


	public Parking(int capacity) {
		mCapacity = capacity;
		mVehicles = new Vehicle[mCapacity];

		setDefaultStates();
		printInfo();
	}

	public Parking(Vehicle[] vehicles) {
		mVehicles = vehicles;
		mCapacity = vehicles.length;
		countVehicles();

		setDefaultStates();
		printInfo();
	}


	private void setDefaultStates(){
		mOpenState = new OpenState(this);
		mClosedState = new ClosedState(this);

		mState = mOpenState;
		if (isFull()) {
			mState = mClosedState;
		}
	}


	public void setAddress(String address) {
		mAddress = address;
	}

	public int getCount() {
		return mCount;
	}

	public void countVehicles() {
		int count = 0;
		for (Vehicle v: mVehicles) {
			if (v != null) {
				count++;
			}
		}
		mCount = count;
	}

	public int getCapacity() {
		return mCapacity;
	}

	public Vehicle[] getVehicles() {
		return mVehicles;
	}

	public State getOpenState() {
		return mOpenState;
	}

	public State getClosedState() {
		return mClosedState;
	}

	public void setState(State state) {
		mState = state;
	}

	@Override
	public String toString() {
		if (mAddress == null) {
			return "Parking";
		}
		return "Parking on " + mAddress;
	}

	public void open() {
		mState.open();
	}

	public void close() {
		mState.close();
	}

	public void checkIn(Vehicle vehicle) {
		mState.add(vehicle);
	}

	public void checkIn(Vehicle vehicle, int place) {
		mState.add(vehicle, place);
	}

	public void checkOut(int place) {
		mState.remove(place);
	}


	public boolean isFull() {
		return mCount == mCapacity;
	}

	public void clearAll() {
		Arrays.fill(mVehicles, null);
		mCount = 0;
		System.out.println(this + " is free of vehicles.");
	}

	public int getAvailable() {
		return (mCapacity - mCount);
	}

	public void printAvailable() {
		System.out.println("Number of available parking lots: " + getAvailable() + ".");
		System.out.println();
	}

	public void printAllVehicles() {
		System.out.println("There are " + mCount + " vehicles in the parking:");
		for (int i = 0; i < mVehicles.length; i++) {
			System.out.println("Parking lot " + (i + 1) + ": " + mVehicles[i] + ";");
		}
		System.out.println();
	}

	public void printInfo(){
		System.out.println(this + ". Capacity: " + mCapacity + ".");
		printAvailable();
	}
}
