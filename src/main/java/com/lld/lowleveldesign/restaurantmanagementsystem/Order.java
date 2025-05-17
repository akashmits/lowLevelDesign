package com.lld.lowleveldesign.restaurantmanagementsystem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class Order {
    private long orderId;
    private List<Item> items;
    private double totalPrice;
    private Date createdDate;
    private OrderStatus status;
}
