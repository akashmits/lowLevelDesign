package com.lld.lowleveldesign.parkinglot1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Floor {
    int floorNo;
    List<Slot> slots;


}
