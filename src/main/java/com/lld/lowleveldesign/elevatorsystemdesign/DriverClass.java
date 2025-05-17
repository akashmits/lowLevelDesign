package com.lld.lowleveldesign.elevatorsystemdesign;


import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;

public class DriverClass {
    List<Elevator> elevatorList;

    Map<Direction, SortedSet<Elevator>> directionSortedElevator;

    private DriverClass(){
        directionSortedElevator=new ConcurrentHashMap<>();
    }
}
