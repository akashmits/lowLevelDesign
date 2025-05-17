package com.lld.lowleveldesign.parkinglot1;

import lombok.Data;

@Data
public class BasePrice {
    private VehicleType vehicleType;
    private int pricePerHour;

    public BasePrice(VehicleType vehicleType, int pricePerHour){
        this.pricePerHour=pricePerHour;
        this.vehicleType=vehicleType;
    }

}

