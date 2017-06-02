package com.courses.parking;

public interface State {
	void open();
	void close();
	int add(Vehicle vehicle);
	boolean add(Vehicle vehicle, int place);
	boolean remove(int place);


}
