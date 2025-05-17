package com.lld.lowleveldesign.swiggy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> orderItems;
    private OrderStatus orderStatus;
    private DeliveryAgent deliveryAgent;

    public Order(String id,Customer customer,Restaurant restaurant){
        this.id=id;
        this.customer=customer;
        this.restaurant=restaurant;
        this.orderItems=new ArrayList<>();
        this.orderStatus=OrderStatus.PENDING;
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        orderItems.remove(orderItem);
    }

    public void setStatus(OrderStatus status){
        this.orderStatus=status;
    }
    public void assignDeliveryAgent(DeliveryAgent agent) {
        this.deliveryAgent = agent;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return orderStatus;
    }

}
