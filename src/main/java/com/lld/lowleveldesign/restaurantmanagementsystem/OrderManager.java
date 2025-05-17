package com.lld.lowleveldesign.restaurantmanagementsystem;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class OrderManager {
    AtomicLong atomicLong;

    private static OrderManager orderManager;

    private OrderManager(){
        atomicLong = new AtomicLong();
    }

    public static OrderManager getInstance(){
        if(orderManager==null){
           synchronized (OrderManager.class){
               orderManager=new OrderManager();
           }
        }
        return  orderManager;
    }
    public Order createOrder(Customer customer, List<Item> items)    {
        Order order= Order.builder().orderId(atomicLong.incrementAndGet()).createdDate(new Date()).items(items).
        status(OrderStatus.IN_QUEUE).totalPrice(calculatePrice(items)).build();
        //state machine diagram
        customer.getOrderList().add(order);
        return order;
    }

    private double calculatePrice(List<Item> items){
        double totalPrice=0;

        for(Item item:items){
            totalPrice+=item.getPrice();
        }
        return totalPrice;
    }
}
