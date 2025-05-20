package com.jpractice.parkinglot;

import java.util.*;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numSpots) {
        this.floor = flr;
        this.spots = new ParkingSpot[numSpots];
        this.availableSpots = numSpots;

        for (int i = 0; i < numSpots; i++) {
            VehicleSize sz = (i < numSpots / 4) ? VehicleSize.MOTORCYCLE :
                             (i < numSpots / 2) ? VehicleSize.COMPACT :
                             VehicleSize.LARGE;
            spots[i] = new ParkingSpot(this, i, sz);
        }
    }

    public boolean parkVehicle(Vehicle v) {
        int spotsNeeded = v.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;

        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.isAvailable() && v.canFitInSpot(spot)) {
                if (lastRow == -1 || i / SPOTS_PER_ROW == lastRow) {
                    lastRow = i / SPOTS_PER_ROW;
                    spotsFound++;
                } else {
                    spotsFound = 1;
                    lastRow = i / SPOTS_PER_ROW;
                }

                if (spotsFound == spotsNeeded) {
                    // Found enough spots
                    for (int j = i - spotsNeeded + 1; j <= i; j++) {
                        spots[j].park(v);
                    }
                    availableSpots -= spotsNeeded;
                    return true;
                }
            } else {
                spotsFound = 0;
                lastRow = -1;
            }
        }
        return false;
    }

    public void spotFreed() {
        availableSpots++;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}
