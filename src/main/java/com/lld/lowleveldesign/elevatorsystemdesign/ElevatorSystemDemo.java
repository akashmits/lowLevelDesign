package com.lld.lowleveldesign.elevatorsystemdesign;

public class ElevatorSystemDemo {
    public static void main(String [] arg){
        ElevatorController controller= new ElevatorController(3,10);
        controller.requestElevator(5,10);
        controller.requestElevator(7,10);
        controller.requestElevator(5,10);
        controller.requestElevator(8,4);


    }
}
