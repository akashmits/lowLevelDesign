package com.lld.lowleveldesign.parkinglot;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParkingDetails {
    int parkingId;
    int floor;
    VehicleType vehicleType;
    ParkingLotStatus parkingLotStatus;
}
