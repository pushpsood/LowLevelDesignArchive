package com.lld.ParkingLot.payment;


import com.lld.ParkingLot.model.PaymentStatus;

import java.util.Date;

// Payment is an abstract class
public abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public abstract boolean initiateTransaction();
}

