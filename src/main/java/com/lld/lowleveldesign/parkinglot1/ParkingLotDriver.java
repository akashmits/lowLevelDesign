package com.lld.lowleveldesign.parkinglot1;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDriver {
    public static void main(String [] arg) throws Exception {
        ParkingLot parkingLot= new ParkingLot();

        BasePrice basePrice = new BasePrice(VehicleType.TWO_WHEELER,10);
        parkingLot.addPrice(VehicleType.TWO_WHEELER,basePrice);


        Slot slot1 = new Slot(1,1,VehicleType.TWO_WHEELER,SlotStatus.FREE);
        Slot slot2 = new Slot(2,1,VehicleType.TWO_WHEELER,SlotStatus.FREE);
        Slot slot3 = new Slot(3,1,VehicleType.TWO_WHEELER,SlotStatus.FREE);
        Slot slot4 = new Slot(4,1,VehicleType.TWO_WHEELER,SlotStatus.FREE);
        List<Slot> slots= new ArrayList<>();

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);


        parkingLot.addFloorSlot(1,slots);

        Slot slot = parkingLot.findParkingLot(VehicleType.TWO_WHEELER);
        System.out.println("Slot:"+slot);
        ParkVehicle parkVehicleInfo=parkingLot.parkVehicle(slot,"ABC0000001");
        System.out.println("parkVehicleInfo:"+parkVehicleInfo);
        ParkVehicle checkoutVehicle=parkingLot.checkOutVehicle("ABC0000001");
        System.out.println("checkoutVehicle:"+checkoutVehicle);



    }
}
