package com.lld.lowleveldesign.parkinglot1;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Builder
@Data
@ToString
public class ParkVehicle {
    private Slot slot;
    private double totalPrice;
    private String vehicleNo;
    private long vehicleCheckInTime;
    private long vehicleCheckOutTime;
}
