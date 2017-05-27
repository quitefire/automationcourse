package com.courses;

import com.courses.parking.models.Car;
import com.courses.parking.models.Motorcycle;
import com.courses.parking.models.Parking;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingTest {

    private static Parking parking;

    @Before
    public void setUp() {
        Car car = new Car("TestCar", "Test");
        Motorcycle motorcycle = new Motorcycle("TestMotorcycle", "TEST");
        parking = new Parking(5);
        parking.openParking();
        // add some vehicles for tests
        parking.addVehicleByPlaceNumber(car, 0);
        parking.addVehicleByPlaceNumber(motorcycle, 2);
    }

    @After
    public void tearDown() {
        parking = null;
    }


    @Test
    public void testAddVehicleByPlaceNumber() {
        int actual = parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 3);
        Assert.assertEquals(3, actual);
    }


    @Test
    public void testAddVehicleByPlaceNumberWhenPlaceIsReserved() {
        int actual = parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 2);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testAddVehicleByPlaceNumberWhenVehicleIsNull() {
        Car car = null;
        int actual = parking.addVehicleByPlaceNumber(car, 4);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testTakeVehicleByPlaceNumber() {
        Assert.assertNotNull(parking.takeVehicleByPlaceNumber(0));
    }

    @Test
    public void testTakeVehicleByPlaceNumberWhenThereIsNoVehicle() {
        Assert.assertNull(parking.takeVehicleByPlaceNumber(1));
    }

    @Test
    public void testAddVehicleToFreeParkingSpace() {
        int actual = parking.addVehicleToFreeParkingSpace(new Car("Mercedes", "AV 2335 TD"));
        Assert.assertEquals(1, actual);
    }


    @Test
    public void testFindFreeParkingSpace() {
        Assert.assertNotNull(parking.findFreeParkingSpace());
    }

    @Test
    public void testFindFreeParkingSpaceWhenFreeSpacesNotAvailable() {
        // Fill left parking spaces for this test
        parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 1);
        parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 3);
        parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 4);
        // Check that parking does not have free spaces
        Assert.assertNull(parking.findFreeParkingSpace());
    }

    @Test
    public void testClearParkingSpaceByPlaceNumber() {
        Assert.assertEquals(2, parking.clearParkingSpaceByPlaceNumber(2));
    }

    @Test
    public void show10() {
        parking.showAllVehiclesInParking();
    }

}
