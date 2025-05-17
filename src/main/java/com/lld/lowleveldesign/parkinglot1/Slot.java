package com.lld.lowleveldesign.parkinglot1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Slot {
    private int slotId;
    private int floorNo;
    private VehicleType vehicleType;
    private SlotStatus slotStatus;
}
