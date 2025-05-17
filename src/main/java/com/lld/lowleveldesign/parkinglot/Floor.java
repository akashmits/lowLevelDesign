package com.lld.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    public Floor(int floorNo){
        this.floorNo=floorNo;
        this.parkingLots = new ArrayList<>();
    }
    int floorNo;
    List<ParkingDetails> parkingLots;
}
