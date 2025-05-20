package com.jpractice.parkinglot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize size;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int num, VehicleSize size) {
        this.level = level;
        this.spotNumber = num;
        this.size = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean fit(Vehicle v) {
        return isAvailable() && v.canFitInSpot(this);
    }

    public boolean park(Vehicle v) {
        if (!fit(v)) return false;
        this.vehicle = v;
        v.parkInSpot(this);
        return true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void removeVehicle() {
        vehicle = null;
        level.spotFreed();
    }
}
