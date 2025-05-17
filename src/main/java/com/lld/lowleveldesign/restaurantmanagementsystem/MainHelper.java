package com.lld.lowleveldesign.restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainHelper {
    public static void main(String [] arg){
        RestaurantManager restaurantManager= RestaurantManager.getInstance();
        List<String> ingredients= new ArrayList<>();
        ingredients.add("panner");
        ingredients.add("tomato");


        Item item1= Item.builder().id(1).name("paneer").price(100).category(Category.VEGITABLE).ingredients(ingredients)
                .build();

        List<String> ingredients1= new ArrayList<>();
        ingredients1.add("Wheat");


        Item item2= Item.builder().id(2).name("Chapti").price(10).category(Category.BREAD).ingredients(ingredients1)
                .build();

        List<Item>  items= new ArrayList<>();

        items.add(item1);
        items.add(item2);
        List<Integer> quantity = new ArrayList<>();
        quantity.add(10);
        quantity.add(100);

        restaurantManager.setInventory(items,quantity);


        Map<Long,Item> menuList=restaurantManager.getMenuList();
        System.out.println("ItemList :: ");
       for(Long itemId:menuList.keySet()){
           System.out.println("Item id "+itemId+", Item details :"+menuList.get(itemId));
       }


       Customer customer =restaurantManager.createCustomer("Akash");

       System.out.println("Customer :"+customer);

       List<Item> orderItem = new ArrayList<>();
        orderItem.add(menuList.get(1l));
        System.out.println("Order Item list :"+orderItem);
        Order order = restaurantManager.createOrder(customer,orderItem);

        System.out.println("Order created :"+order);
        System.out.println("::::::::::::::::::::::::");
        System.out.println("Customer order list :"+customer.getOrderList());



    }
}
