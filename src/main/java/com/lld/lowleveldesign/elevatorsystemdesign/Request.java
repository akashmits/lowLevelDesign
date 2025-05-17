package com.lld.lowleveldesign.elevatorsystemdesign;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Request {
   private int currentFloor;
    private int destinationFloor;
}
