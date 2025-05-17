package com.lld.lowleveldesign.parkinglot;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private VehicleDetails parkedVehicle;


    public ParkingSpot(int spotNumber, VehicleType vehicleType)
        {
            this.spotNumber=spotNumber;
            this.vehicleType=vehicleType;
        }

        public synchronized boolean isAvailable(){
            return parkedVehicle==null;
        }

        public synchronized  void parkedVehicle(VehicleDetails vehicleDetails){
            if(isAvailable() && vehicleDetails.vehicleType.equals(vehicleType)){
                parkedVehicle=vehicleDetails;
            }else{
                throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
            }
        }

        public synchronized  void unparkedVehicle(){
        parkedVehicle=null;
        }

        public VehicleType getVehicleType(){
        return vehicleType;
        }

        public VehicleDetails getParkedVehicle(){
        return parkedVehicle;
        }

        public  int getSpotNumber(){
        return spotNumber;
        }

}
