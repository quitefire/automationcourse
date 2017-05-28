package com.courses;

import com.courses.parking.exceptions.InvalidPlaceNumberException;
import com.courses.parking.exceptions.ParkingClosedException;
import com.courses.parking.models.Car;
import com.courses.parking.models.Motorcycle;
import com.courses.parking.models.Parking;
import org.junit.*;

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
        Assert.assertTrue(parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 3));
    }


    @Test
    public void testAddVehicleByPlaceNumberWhenPlaceIsReserved() {
        Assert.assertFalse(parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 2));
    }

    @Test(expected = ParkingClosedException.class)
    public void testAddVehicleWhenParkingIsClosed() {
        parking.closeParking();
        parking.addVehicleToFreeParkingSpace(new Car("TEST", "TEST"));
    }

    @Test(expected = InvalidPlaceNumberException.class)
    public void testAddVehicleWhenParkingPlaceNumberDoesNotExist() {
        parking.addVehicleByPlaceNumber(new Car("Mercedes", "AV 2335 TD"), 100);
    }

    @Test(expected = NullPointerException.class)
    public void testAddVehicleByPlaceNumberWhenVehicleIsNull() {
        parking.addVehicleByPlaceNumber(null, 4);
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
        Assert.assertTrue(parking.addVehicleToFreeParkingSpace(new Car("Mercedes", "AV 2335 TD")));
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
        Assert.assertTrue(parking.clearParkingSpaceByPlaceNumber(2));
    }
}
