package com.jpractice.parkinglot;

public class ParkingLot {
    private Level[] levels;

    public ParkingLot(int numLevels, int spotsPerLevel) {
        levels = new Level[numLevels];
        for (int i = 0; i < numLevels; i++) {
            levels[i] = new Level(i, spotsPerLevel);
        }
    }

    public boolean parkVehicle(Vehicle v) {
        for (Level level : levels) {
            if (level.parkVehicle(v)) {
                System.out.println("Parked on level " + level);
                return true;
            }
        }
        return false;
    }
}
