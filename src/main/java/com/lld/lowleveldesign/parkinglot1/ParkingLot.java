package com.lld.lowleveldesign.parkinglot1;

import java.util.*;

public class ParkingLot {

    private Map<Integer,Floor> floorSlotInformation;
    private Map<String,ParkVehicle> parkedVehicle;
    private Map<VehicleType,BasePrice> priceDetails;
    private Map<String,ParkVehicle> historicalParkVehicles;
    public ParkingLot(){
        floorSlotInformation= new TreeMap<>();
        parkedVehicle= new HashMap<>();
        priceDetails= new HashMap<>();
        historicalParkVehicles= new HashMap<>();
    }

    public void addPrice(VehicleType vehicleType,BasePrice basePrice){
        priceDetails.put(vehicleType,basePrice);
    }

    public void addFloorSlot(int floorNo, List<Slot> slots){
        Floor floor = floorSlotInformation.get(floorNo);

        if(floor==null){
            floor = new Floor(floorNo,slots);
            floorSlotInformation.put(floorNo,floor);
        }
        floorSlotInformation.get(floorNo).getSlots().addAll(slots);

    }


    public Slot findParkingLot(VehicleType vehicleType) throws Exception {

        for(Integer floorNo : floorSlotInformation.keySet()){
            Floor floorSlots= floorSlotInformation.get(floorNo);
            for(Slot slot: floorSlots.getSlots()){
                if(slot.getSlotStatus().equals(SlotStatus.FREE))
                {
                    slot.setSlotStatus(SlotStatus.PENDING);
                    return slot;
                }
            }
        }

        throw new Exception("Parking lot is full");
    }

    public ParkVehicle parkVehicle(Slot slot, String vehicleNo) throws Exception {

        if(slot.getSlotStatus().equals(SlotStatus.PENDING) || slot.getSlotStatus().equals(SlotStatus.FREE)){
            ParkVehicle parkVehicle= ParkVehicle.builder().vehicleNo(vehicleNo)
                    .vehicleCheckInTime(System.currentTimeMillis()).slot(slot).build();
            slot.setSlotStatus(SlotStatus.ALLOTED);
            parkedVehicle.put(vehicleNo,parkVehicle);
            return parkVehicle;
        }
        throw  new Exception("Please try again,This parking alot is busy");
    }

    public ParkVehicle checkOutVehicle(String vehicleId){
        ParkVehicle parkVehicle=parkedVehicle.get(vehicleId);

        BasePrice basePrice =priceDetails.get(parkVehicle.getSlot().getVehicleType());

        long timeDuration =System.currentTimeMillis() -parkVehicle.getVehicleCheckInTime();
        parkVehicle.setVehicleCheckOutTime(System.currentTimeMillis());

        long totalHour= timeDuration/(1000*60*60)+ timeDuration%(1000*60*60)>0?1:0;

        long totalFair =  totalHour*basePrice.getPricePerHour();
        parkVehicle.setTotalPrice(totalFair);
        parkedVehicle.remove(vehicleId);
        historicalParkVehicles.put(vehicleId,parkVehicle);
        parkVehicle.getSlot().setSlotStatus(SlotStatus.FREE);
        return parkVehicle;
    }
}
