package com.lld.lowleveldesign.multithreading.collections;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {
    public static void main(String [] arg){
        ConcurrentSkipListMap<String,Integer> concurrentSkipListMap= new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put("Akash",100);
        concurrentSkipListMap.put("Suvidha",101);
        concurrentSkipListMap.put("Suvidha1",101);
        concurrentSkipListMap.put("Jeevansh",120);
        concurrentSkipListMap.put("Jeevansh1",120);
        concurrentSkipListMap.put("Jeevansh2",120);

        System.out.println("Concurrent Skip List Map:"+concurrentSkipListMap);

        System.out.println("Concurrent Skip List Map:"+concurrentSkipListMap.ceilingKey("Suvidha"));

    }
}
