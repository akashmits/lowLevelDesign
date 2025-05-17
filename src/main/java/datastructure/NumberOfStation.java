package datastructure;

import java.util.Arrays;

public class NumberOfStation {

    //arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, //sortedTime
    //dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

    //dep[] = {9:10, 11:20, 11:30,12:00, 19:00, 20:00}

    // 1st approach pick each interval and find intersaction interval

    // 2nd approach: sortDeparture time (nlog)

    //arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, //sortedTime
    //dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
    public static void main(String [] arg){
        int arrival[] ={900, 940, 950, 1100, 1500, 1800};
        int departure[] ={910, 1200, 1120, 1130, 1900, 2000};
        int numberOfStation=numberOfStation(arrival,departure);
        System.out.println("Number of Station :"+numberOfStation);


        arrival = new int[]{900, 940};
        departure = new int[]{910, 1200};
        numberOfStation=numberOfStation(arrival,departure);
        System.out.println("Number of Station :"+numberOfStation);


         arrival =new int []{900, 940, 950, 1100, 1500, 1800};
         departure =new int []{2100, 1200, 1120, 1130, 1900, 2000};

         numberOfStation=numberOfStation(arrival,departure);
        System.out.println("Number of Station :"+numberOfStation);



    }
    public static int numberOfStation(int [] startTime,int [] departureTime){
        Arrays.sort(departureTime);
        if(startTime.length==0) return 0;

        int maxRequireStation=1;
        int startIndex=1;
        int departureIndex=0;
        int currentStation=1;

        while(startIndex<startTime.length){
            if(startTime[startIndex] >departureTime[departureIndex]){
                --currentStation;
                ++departureIndex;
            } else {
                ++currentStation;
                ++startIndex;
            }
            maxRequireStation=Math.max(currentStation,maxRequireStation);

        }

        return maxRequireStation;
    }

    //if not sort,is it possible
}
