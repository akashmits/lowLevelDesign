package com.lld.lowleveldesign.restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantManager {
    Map<Long,Integer> inventory;
    Map<Long,Item> menuList;
    private static RestaurantManager restaurantManager;
    private OrderManager orderManager;
    private CustomerManager customerManager;

    private RestaurantManager(){
        inventory=new ConcurrentHashMap<>();
        menuList= new ConcurrentHashMap<>();
        orderManager = OrderManager.getInstance();
        customerManager =CustomerManager.getInstance();
    }

    public void setInventory(List<Item> items, List<Integer> quantity){
        System.out.println("Request Received fot set items : "+items);
        for(int i=0;i<items.size();i++){
            inventory.put(items.get(i).getId(),inventory.getOrDefault(items.get(i).getId(),0)+quantity.get(i));
            menuList.put(items.get(i).getId(),items.get(i));
        }

        System.out.println(inventory +"|  menu List |"+menuList);
    }

    public Map<Long,Item> getMenuList(){
        System.out.println("Menu list :"+menuList);
        return menuList;
    }
    public static RestaurantManager getInstance(){
        if(restaurantManager==null){
            synchronized(RestaurantManager.class){
                restaurantManager= new RestaurantManager();
            }
        }
        return restaurantManager;
    }

    public Customer createCustomer(String name){
            return customerManager.create(name);
    }
    public Order createOrder(Customer customer,List<Item> items){
            return orderManager.createOrder(customer,items);
    }

}
