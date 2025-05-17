package com.lld.lowleveldesign.multithreading;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ImmutableClass {

    public static void main(String [] arg){
        Calendar c1 = Calendar.getInstance();

        // Set Month
        // MONTH starts with 0 i.e. ( 0 - Jan)
        c1.set(Calendar.MONTH, 11);

        // Set Date
        c1.set(Calendar.DATE, 05);

        // Set Year
        c1.set(Calendar.YEAR, 1996);
        Date date=  c1.getTime();
        List<String> address= new ArrayList<>();
        address.add("Noida");
        address.add("SBL");

        Employee em= new Employee(date,address,"Akash","ABC123123");

        System.out.println("Address :" +em.getAddress());

        address.add("Gwalior");
        System.out.println("Address :" +em.getAddress());

        System.out.println("Old Date :" +em.getDate());

       // Date date1=em.getDate();
        date.setTime(1733600598);
        System.out.println("new Date :" +em.getDate());


    }
}
