package com.lld.lowleveldesign.parkinglot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotServiceImpl implements ParkingLotService{

    // floor , vehicleType wise,parking lot

    List<Map<VehicleType,List<ParkingDetails>>> parkingLots;
    Map<VehicleType,List<Floor>> vehicleTypeWiseParking;
    Map<String,ParkingTicket> vehiclesDetails;

    private ParkingLotServiceImpl(){

        vehicleTypeWiseParking= new ConcurrentHashMap<>();
        vehiclesDetails = new ConcurrentHashMap<>();
    }
    // this api is used for admin only
    @Override
    public void addParking(int floorNo, VehicleType vehicleType) {
        List<Floor> floors=vehicleTypeWiseParking.get(vehicleType);

        Floor floor =floors.get(floorNo);

        if(floor == null){
            floor= new Floor(floorNo);
        }

       int size=floor.parkingLots.size();

        ParkingDetails parkingDetails= ParkingDetails.builder().
                parkingId(size+1).floor(floorNo).parkingLotStatus(ParkingLotStatus.FREE).build();
        floor.parkingLots.add(parkingDetails);

    }

    @Override
    public List<Floor> getParkingLot(VehicleType vehicleType) {
       List<Floor> parkingLots= vehicleTypeWiseParking.get(vehicleType);
        return parkingLots;
    }

    @Override
    public ParkingTicket assignParking(VehicleType vehicle, VehicleDetails vehicleDetails) {
        return null;
    }

    @Override
    public ParkingTicket checkOutAndCalculateCharge(String vehicleNo) {
        return null;
    }
}
