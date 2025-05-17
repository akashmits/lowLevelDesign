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
public class Customer {
    private Long id;
    private String name;
    private List<Order> orderList;
    private Date createdDate;
}
