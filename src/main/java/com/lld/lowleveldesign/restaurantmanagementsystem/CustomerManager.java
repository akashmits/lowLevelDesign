package com.lld.lowleveldesign.restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerManager {
    private AtomicLong customerUniqueGenerator;
    private static CustomerManager customerManager;
    Map<Long,Customer> customerMap;

    private CustomerManager(){
        customerUniqueGenerator= new AtomicLong();
        customerMap = new ConcurrentHashMap<>();
    }

    public static CustomerManager getInstance(){
        if(customerManager==null){
            synchronized (CustomerManager.class){
                customerManager=new CustomerManager();
            }
        }
        return customerManager;
    }
    public Customer get(Long customerId){
        return  customerMap.get(customerId);
    }
    public Customer create(String name){
        Customer customer = Customer.builder().id(customerUniqueGenerator.incrementAndGet()).createdDate(new Date())
                .name(name).orderList(new ArrayList<>()).build();
        customerMap.put(customer.getId(),customer);
        return customer;
    }
}
