package com.jpractice.parkinglot;

public class ParkingLotTest {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 30);

        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle bus1 = new Bus();
        Vehicle bike1 = new Motorcycle();

        System.out.println("Car1 parked: " + lot.parkVehicle(car1));
        System.out.println("Bus1 parked: " + lot.parkVehicle(bus1));
        System.out.println("Bike1 parked: " + lot.parkVehicle(bike1));
        System.out.println("Car2 parked: " + lot.parkVehicle(car2));
    }
}
