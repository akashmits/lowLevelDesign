package com.lld.lowleveldesign.scrapiamachinecodinground;

import snakeLadder.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class KitDataRepository {

    TreeSet<TestCentre> testCentreList; // we not require
    Map<Long,Integer> inventoryDetails;

    public void saveTestCentre( List<TestCentre> testCentres){
        testCentreList= new TreeSet<TestCentre>();
        inventoryDetails= new ConcurrentHashMap<>();
       for(TestCentre testCentre:testCentres){
           testCentreList.add(testCentre);
           inventoryDetails.put(testCentre.getId(),testCentre.getNoOfTestingKit());
       }
    }

    public int getInventory(Long testCentreId){
        return inventoryDetails.get(testCentreId);
    }
    public void updateInventory(Long testCentreId, int countCodeium) throws Exception {
       int count= inventoryDetails.getOrDefault(testCentreId,0);

       if(count==0 && countCodeium<0){
           throw new Exception("Inventory not available, please check with other test centre");
       }

       if(count+countCodeium>=0){
            inventoryDetails.put(testCentreId,count+countCodeium);
        }

    }

    public  PriorityQueue<Pair<TestCentre,Double>> findDataCentre(Location location, int count){
        List<TestCentre> result = new ArrayList<>();
        PriorityQueue<Pair<TestCentre,Double>> testCentres = new PriorityQueue<>();

        for(TestCentre testCentre : testCentreList){
            double distance=Math.sqrt(Math.pow(location.lattitude-testCentre.getLocation().lattitude,2)+Math.pow(location.longitude-testCentre.getLocation().longitude,2));
            if(testCentres.size()>=count){
                if(testCentres.peek().v>distance){
                    testCentres.poll();
                    testCentres.add(new Pair<>(testCentre,distance));
                }
            }else{
                testCentres.add(new Pair<>(testCentre,distance));
            }
        }
        return testCentres;
    }
}
