package com.lld.lowleveldesign.swiggy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MenuItem {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private boolean isAvailable=true;

    public MenuItem(String id, String name,String description,double price){
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.isAvailable=true;

    }

}
