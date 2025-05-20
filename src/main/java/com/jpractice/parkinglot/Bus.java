package com.jpractice.parkinglot;

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }
}
