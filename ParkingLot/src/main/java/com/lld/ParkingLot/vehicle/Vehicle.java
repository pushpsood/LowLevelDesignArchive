package com.lld.ParkingLot.vehicle;

import com.lld.ParkingLot.components.ParkingTicket;

// Vehicle is an abstract class
public abstract class Vehicle {
    private int licenseNo;
    public abstract void assignTicket(ParkingTicket ticket);
}