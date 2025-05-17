package com.lld.lowleveldesign.scrapiamachinecodinground;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class WaitingListService {
    LinkedHashMap<String, Set<Long>>  waitingUserList;
    KitControllerService kitControllerService;
    public WaitingListService(KitControllerService kitControllerService){
        this.kitControllerService=kitControllerService;
        waitingUserList= new LinkedHashMap<String, Set<Long>>();
    }

    public void addUserIntoWaitingList(String userId, Set<Long> testCentreIds){
        waitingUserList.put(userId,testCentreIds);
    }

    public void notify(Long testCenterId){

        for(String s: waitingUserList.keySet()){
            if(waitingUserList.get(s).contains(testCenterId) && kitControllerService.getInventory(testCenterId)>0){
                kitControllerService.updateInvertory(testCenterId,-1);
                System.out.println("Testing Kit alloted to user |"+s +" testCenterId |"+testCenterId);
            }
        }
    }
}

//AssignementStrategy
//{
//    public void addUserIntoWaitingList(String userId, Set<Long> testCentreIds);
//    public void notify(Long testCenterId);
//}
// Priority implements Assignement{
// }

// FCFS

//
