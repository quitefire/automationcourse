package com.courses.parking;

public class ClosedState implements State {
	private Parking mParking;

	public ClosedState(Parking parking) {
		mParking = parking;
	}

	@Override
	public void open() {
		System.out.println("Open " + mParking);
		mParking.setState(mParking.getOpenState());
	}

	@Override
	public void close() {
		System.out.println(mParking + " is already closed. You can not close it.");
	}

	@Override
	public int add(Vehicle vehicle) {
		System.out.println(mParking + " is closed. You can not check-in new vehicle.");
		return 0;
	}

	@Override
	public boolean add(Vehicle vehicle, int place) {
		System.out.println(mParking + " is closed. You can not add new vehicle.");
		return false;
	}

	@Override
	public boolean remove(int place) {
		Vehicle[] vehicleList = mParking.getVehicles();

		if (vehicleList.length > 0) {
			Vehicle vehicle = vehicleList[place - 1];
			vehicleList[place - 1] = null;
			mParking.countVehicles();
			//mParking.setCount(mParking.getCount() - 1);

			System.out.println(vehicle + " was taken from the parking lot number " + (place) + ".");

			if (!mParking.isFull()) {
				mParking.open();
			}
			return true;
		}
		return false;

	}

}
