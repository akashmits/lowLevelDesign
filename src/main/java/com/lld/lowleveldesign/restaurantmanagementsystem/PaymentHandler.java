package com.lld.lowleveldesign.restaurantmanagementsystem;

public interface PaymentHandler {
    public boolean doPayment(Customer customer,Order order);
}
