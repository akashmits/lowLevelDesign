package glance;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimit {

    Map<Integer, UserLimit> userData;
    Map<String,Integer> teamLimitConfig;

    public UserRateLimit( Map<String,Integer> teampLimitConfig){
        userData= new ConcurrentHashMap<>();
        this.teamLimitConfig=teampLimitConfig;
    }

    public void checkRateLimit(Integer userId, String teamName) {

        if(userId==null || teamName==null){
            System.out.println("Invalid details "+teamName);
            //throw  new Exception("Invalid details");
            return;
        }

       // System.out.println("Request Receive : user Id |"+userId+" |teamName |"+teamName);
        int currentHour = new Date().getHours();
        int currentDay= new Date().getDay();

        Integer teamLimit = teamLimitConfig.get(teamName);

        if(teamLimit==null || teamLimit==0){
            System.out.println("You are not eligible for sent notification"+teamName);
           // throw  new Exception("You are not eligible for sent notification");
            return;
        }

        UserLimit userLimit= userData.get(userId);

        if(userLimit==null){
            userLimit= new UserLimit();
            userLimit.currentDate=currentDay;
            userLimit.currentHour=currentHour;
            userLimit.teamsNotificationCount= new HashMap<>();
            userLimit.teamsNotificationCount.put(teamName,1);
            userData.put(userId,userLimit);
        }else{


            if(userLimit.currentHour==currentHour && userLimit.currentDate==currentDay){
                int totalCountSent=0;
                for(String currTeamName: userLimit.teamsNotificationCount.keySet()){
                    totalCountSent+=userLimit.teamsNotificationCount.get(currTeamName);
                }

                if(totalCountSent>=teamLimitConfig.get("totalUserLimit")){
                    System.out.println("otal User Limit Consumed: UserId |"+userId);
                   // throw  new Exception("Total User Limit Consumed: UserId"+userId);
                    return;
                }

                Integer alreadySentCount=userLimit.teamsNotificationCount.get(teamName);

                if(alreadySentCount==null){
                    userLimit.teamsNotificationCount.put(teamName,1);
                }else if(alreadySentCount>=teamLimit){
                    System.out.println("Teams consume limit for the user |"+userId+" TeamName "+teamName);
                    //throw  new Exception("Teams consume limit for the user");
                    return;
                }else{
                    userLimit.teamsNotificationCount.put(teamName,alreadySentCount+1);
                }
            }else{
                userLimit.currentDate=currentDay;
                userLimit.currentHour=currentHour;
                userLimit.teamsNotificationCount= new HashMap<>();
                userLimit.teamsNotificationCount.put(teamName,1);
            }
        }

        System.out.println("Notification Sent to the user "+userId+" Team Name |"+teamName);

    }
}
