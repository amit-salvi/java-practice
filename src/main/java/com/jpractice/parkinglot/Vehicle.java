package com.jpractice.parkinglot;

import java.util.*;

public abstract class Vehicle {
    protected List<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected VehicleSize size;
    protected int spotsNeeded;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        for (ParkingSpot spot : parkingSpots) {
            spot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}
