package com.lld.lowleveldesign.parkinglot;

import java.util.Date;

public class ParkingTicket {
    int parkingTicketId;
    int floorNo;
    int parkingLotId;
    VehicleDetails vehicleDetails;
    Date checkIn; //time will be in utc
    Date checkOut;
    Double charge;
}
