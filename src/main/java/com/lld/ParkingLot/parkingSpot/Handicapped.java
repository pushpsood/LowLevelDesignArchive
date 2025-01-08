package com.lld.ParkingLot.parkingSpot;

import com.lld.ParkingLot.vehicle.Vehicle;

public class Handicapped extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        return false;
    }
}