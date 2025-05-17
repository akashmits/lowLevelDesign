package com.lld.lowleveldesign.swiggy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class Restaurant {
    private final String id;
    private final String name;
    private final String address;
    private final List<MenuItem> menuItemList;


    public void addMenu(MenuItem menuItem){
        menuItemList.add(menuItem);
    }

    public void removeMenuItem(MenuItem item){
        menuItemList.remove(item);
    }




}
