package com.lld.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingLot> parkingSpots;

    public Level(int floor, int numSpots){
        this.floor=floor;
        parkingSpots= new ArrayList<>(numSpots);
    }


}
