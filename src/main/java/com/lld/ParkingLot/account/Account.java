package com.lld.ParkingLot.account;

import com.lld.ParkingLot.model.AccountStatus;
import com.lld.ParkingLot.model.Person;
import lombok.Data;

public abstract class Account {
    // Data members
    private String userName;
    private String password;
    private Person person; // Refers to an instance of the Person class
    private AccountStatus status; // Refers to the AccountStatus enum

    public abstract boolean resetPassword();
}