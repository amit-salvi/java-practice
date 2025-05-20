package com.jpractice.parkinglot;

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.COMPACT || spot.getSize() == VehicleSize.LARGE;
    }
}
