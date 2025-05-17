package com.lld.lowleveldesign.ds;

import java.util.Arrays;
import java.util.Comparator;

public class VersionComparator implements Comparator<String> {

    public static void main(String[] args) {
        String[] versions = {"4.5.1", "10", "0.99", "4.5", "1.0.0.1"};

        Arrays.sort(versions, new VersionComparator());

        System.out.println(Arrays.toString(versions));
    }
    @Override
    public int compare(String s1,String s2){
       String [] part1= s1.split("\\.");
        String [] part2= s2.split("\\.");

       // System.out.println(s1+"  "+s2);
        int len= Math.max(part1.length,part2.length);

        for(int i=0;i<len;i++){
            int num1= part1.length>i?Integer.parseInt(part1[i]):0;
            int num2= part2.length>i?Integer.parseInt(part2[i]):0;

            //System.out.println(num1+"  "+num2);

            if(num1 !=num2){
                return Integer.compare(num1,num2);
            }
        }
        return -0;
    }
}
