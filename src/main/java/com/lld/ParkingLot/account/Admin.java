package com.lld.ParkingLot.account;

import com.lld.ParkingLot.components.DisplayBoard;
import com.lld.ParkingLot.components.Entrance;
import com.lld.ParkingLot.components.Exit;
import com.lld.ParkingLot.parkingSpot.ParkingSpot;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends Account {
    // spot here refers to an instance of the ParkingSpot class
    public boolean addParkingSpot(ParkingSpot spot) {
        return false;
    }
    // displayBoard here refers to an instance of the DisplayBoard class
    public boolean addDisplayBoard(DisplayBoard displayBoard) {
        return false;
    }
    // entrance here refers to an instance of the Entrance class
    public boolean addEntrance(Entrance entrance) {
        return false;
    }
    // exit here refers to an instance of the Exit class
    public boolean addExit(Exit exit) {
        return false;
    }

    // Will implement the functionality in this class
    public boolean resetPassword() {
        // definition
        return false;
    }
}
