package com.jpractice.parkinglot;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.MOTORCYCLE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}
