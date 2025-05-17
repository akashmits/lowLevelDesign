package com.lld.lowleveldesign.multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {

    private final Date date;
    private final List<String> address;
    private final String name;
    private final String registrationNum;

    // this is not Stricly immutable class
    public Employee(Date date, List<String> address, String name, String registrationNum, boolean x){
        this.date=date;
        this.address=address;
        this.name= name;
        this.registrationNum=registrationNum;
    }

    public Employee(Date date, List<String> address, String name, String registrationNum){
        this.date= (Date) date.clone();
        this.address=new ArrayList<>(address);
        this.name= name;
        this.registrationNum=registrationNum;
    }


    public Date getDate(){
        return (Date) date.clone();
    }

    public List<String> getAddress(){
        return  new ArrayList<>(address);
    }

    public String getName(){
        return name;
    }

    public String getRegistrationNum(){
        return registrationNum;
    }

}
