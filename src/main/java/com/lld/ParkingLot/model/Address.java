package com.lld.ParkingLot.model;

import lombok.Data;

@Data
public class Address {
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String country;
}