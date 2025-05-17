package com.lld.lowleveldesign.elevatorsystemdesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevatorList;

    public  ElevatorController(int noOfElevator, int currentCapacity){
        elevatorList= new ArrayList<>();

        for(int i=0;i<noOfElevator;i++){
            Elevator elevator= new Elevator(i,currentCapacity);
            elevatorList.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor){
        Elevator optimalElevator = findOptimalElevator(sourceFloor,destinationFloor);
       // System.out.println("Optimal Elevator find :"+optimalElevator);
        optimalElevator.addRequest(new Request(sourceFloor,destinationFloor));
        //optimalElevator.processRequests();

    }

    public Elevator findOptimalElevator(int sourceFloor,int destinationFloor){
        Elevator optimalElevator=null;
        int minDistance= Integer.MAX_VALUE;


        for(Elevator elevator:elevatorList){
            int distance= Math.abs(sourceFloor-elevator.getCurrentFloor());

            if(distance<minDistance){
                minDistance=distance;
                optimalElevator=elevator;
            }
        }
        return optimalElevator;
    }
}
