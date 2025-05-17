package com.lld.lowleveldesign.elevatorsystemdesign;

// 1 10 floor

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

@Data
public class Elevator {
    private final int id;
    private final int capacity;
    private  int currentFloor;
    private Direction currentDirection;
    private final List<Request> requesterList;

    public Elevator(int id, int capacity){
        this.id=id;
        this.capacity=capacity;
        this.currentFloor=1;
        this.currentDirection=Direction.UP;
        requesterList= new ArrayList<>();
    }

    public synchronized void addRequest(Request request){
        if(requesterList.size()<capacity){
            requesterList.add(request);
            System.out.println("Elevator id:"+this.id+", added request:"+request);
            notifyAll();
        }
    }

    public synchronized  Request getNextRequest(){
        while(requesterList.isEmpty()){
            try {
                wait();
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        return requesterList.remove(0);
    }

    public synchronized void processRequests(){
        while(true){
            while(!requesterList.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }

            try{
                wait();
            }catch(InterruptedException ex){
                System.out.println("Interrupted exception");
            }
        }
    }

    public synchronized void processRequest(Request request){
        int startFloor=request.getCurrentFloor();
        int destinationFloor=request.getDestinationFloor();

        if(startFloor<destinationFloor){
            currentDirection=Direction.UP;

            for(int i=startFloor;i<=destinationFloor;i++){
                currentFloor=i;
                System.out.println("Elevator :"+id+" , reched floor :"+currentFloor);

                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println("Elevator :"+id+" , reached destination :"+destinationFloor);

        }else if (startFloor>destinationFloor){
            currentDirection=Direction.DOWN;
            for(int i=startFloor;i>=destinationFloor;i--){
                currentFloor=i;
                System.out.println("Elevator :"+id+" , reched floor :"+currentFloor);

                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    public void run(){
        processRequests();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

}
