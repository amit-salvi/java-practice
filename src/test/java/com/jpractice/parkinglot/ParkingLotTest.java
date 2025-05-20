package com.jpractice.parkinglot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void testCarCanPark() {
        ParkingLot lot = new ParkingLot(1, 10);
        Vehicle car = new Car();
        assertTrue(lot.parkVehicle(car), "Car should be able to park");
    }

    @Test
    public void testMotorcycleCanParkAnywhere() {
        ParkingLot lot = new ParkingLot(1, 10);
        Vehicle bike = new Motorcycle();
        assertTrue(lot.parkVehicle(bike), "Motorcycle should be able to park in any spot");
    }

    @Test
    public void testBusRequires5LargeSpotsInRow() {
        ParkingLot lot = new ParkingLot(1, 5);
        Vehicle bus = new Bus();
        assertFalse(lot.parkVehicle(bus), "Bus should not park if there aren't 5 consecutive large spots");

        // Make room by creating a level with enough large spots
        ParkingLot bigLot = new ParkingLot(1, 20); // more large spots
        Vehicle bus2 = new Bus();
        assertTrue(bigLot.parkVehicle(bus2), "Bus should be able to park if 5 large spots are available");
    }

    @Test
    public void testCarCannotParkWhenFull() {
        ParkingLot lot = new ParkingLot(1, 1); // Only 1 spot
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        assertTrue(lot.parkVehicle(car1));
        assertFalse(lot.parkVehicle(car2), "Second car should not be able to park in full lot");
    }

    @Test
    public void testVehicleClearsSpotsOnExit() {
        ParkingLot lot = new ParkingLot(1, 10);
        Vehicle car = new Car();
        assertTrue(lot.parkVehicle(car));

        // Clear spots
        car.clearSpots();

        // Try to park another car after freeing up space
        Vehicle car2 = new Car();
        assertTrue(lot.parkVehicle(car2), "Another car should park after first car leaves");
    }
}
