package com.lld.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(){
        levels= new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null)
                instance = new ParkingLot();

        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(VehicleDetails vehicleDetails){
            return false;
    }


}
