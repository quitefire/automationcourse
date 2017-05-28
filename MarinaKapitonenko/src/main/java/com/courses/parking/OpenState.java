package com.courses.parking;

public class OpenState implements State {
	private Parking mParking;

	public OpenState(Parking parking) {
		mParking = parking;
	}

	@Override
	public void open() {
		System.out.println(mParking + " is already open. You can not open it.");
	}

	@Override
	public void close() {
		System.out.println("Close " + mParking);
		mParking.setState(mParking.getClosedState());
	}

	@Override
	public int add(Vehicle vehicle) {
		int position = mParking.getCount();

		while (mParking.getVehicles()[position] != null) {
			position++;
		}
		mParking.getVehicles()[position] = vehicle;
		mParking.setCount(position + 1);
		int place = position + 1;
		System.out.println(vehicle + " is parked on the parking lot number " + place + ".");

		if (mParking.isFull()) {
			mParking.close();
		}
		return place;
	}

	@Override
	public boolean add(Vehicle vehicle, int place) {
		if (place > mParking.getCapacity()) {
			System.out.println("There is no parking lot number " + place + ". Parking only has " + mParking.getCapacity() + " parking lots.");
			return false;
		}
		if (mParking.getVehicles()[place - 1] != null) {
			System.out.println("Parking lot number " + place + "is already occupied.");
			return false;
		}

		mParking.getVehicles()[place - 1] = vehicle;
		mParking.setCount(mParking.getCount() + 1);
		System.out.println(vehicle + " is parked on the parking lot number " + place + ".");

		if (mParking.isFull()) {
			mParking.close();
		}
		return true;


	}

	@Override
	public boolean remove(int place) {
		Vehicle[] vehicleList = mParking.getVehicles();

		if (vehicleList.length > 0) {
			Vehicle vehicle = vehicleList[place - 1];
			vehicleList[place - 1] = null;
			mParking.setCount(mParking.getCount() - 1);

			System.out.println(vehicle + " was taken from the parking lot number " + (place) + ".");

			return true;
		}
		return false;

	}
}
