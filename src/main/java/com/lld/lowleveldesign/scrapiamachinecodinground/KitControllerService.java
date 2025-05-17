package com.lld.lowleveldesign.scrapiamachinecodinground;

import snakeLadder.Pair;

import java.util.*;

public class KitControllerService {
    KitDataRepository kitDataRepository;
    WaitingListService waitingListService;


    public KitControllerService(KitDataRepository kitDataRepository){
        this.kitDataRepository=kitDataRepository;
    }

    public void initializeTestCentre(List<TestCentre> testCentreList){
        kitDataRepository.saveTestCentre(testCentreList);
    }
    public Long findTestingCentre(String userId, Location location){
        PriorityQueue<Pair<TestCentre,Double>> queue =kitDataRepository.findDataCentre(location,3);
        Set<Long> testCentreIds  =new HashSet<>();

        while(!queue.isEmpty()){
            Pair<TestCentre,Double> testCentreDetails=queue.poll();
            testCentreIds.add(testCentreDetails.k.getId());
            if(testCentreDetails.k.getNoOfTestingKit()>0){
//Codeium: Your IDE and extension versions are too old. Update your IDE to 2022.3+ and install the latest extension. For help, contact us at https://codeium.com/support
                try {
                    kitDataRepository.updateInventory(testCentreDetails.k.getId(), -1);
                    return testCentreDetails.k.getId();
                }catch(Exception ex){

                }
                }
        }

        // if all test center inventory 0 then we need to add in queue
        // 3 testing  , if any testing center have kit avaialbe then assing it and
        // FCFS
        waitingListService.addUserIntoWaitingList(userId,testCentreIds);


        return null;

    }

    public void updateInvertory(Long testCentreId, int count){
        try {
            kitDataRepository.updateInventory(testCentreId, count);
            // notify waiting list
            waitingListService.notify(testCentreId);

        }catch(Exception ex){

        }
    }

    public int getInventory(Long testCentreId){
        return kitDataRepository.getInventory(testCentreId);
    }
}
