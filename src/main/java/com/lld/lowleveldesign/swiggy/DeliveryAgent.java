package com.lld.lowleveldesign.swiggy;

public class DeliveryAgent {
    private final String id;
    private final String name;
    private final String phone;
    private  Boolean available;

    public DeliveryAgent(String id,String name,String phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.available=true;
    }

    public void setAvailable(Boolean available){
        this.available=available;
    }

    public String getId(){
        return id;
    }

    public Boolean isAvailable(){
        return available;
    }



}
