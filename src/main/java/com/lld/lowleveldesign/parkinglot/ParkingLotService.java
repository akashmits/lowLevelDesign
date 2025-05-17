package com.lld.lowleveldesign.parkinglot;

import java.util.List;

public interface ParkingLotService {
    public void addParking(int floorNo, VehicleType vehicleType);
    public List<Floor> getParkingLot(VehicleType vehicleType);
    public ParkingTicket assignParking(VehicleType vehicle, VehicleDetails vehicleDetails);
    public ParkingTicket checkOutAndCalculateCharge(String vehicleNo);
}
