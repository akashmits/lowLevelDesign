package com.lld.lowleveldesign.restaurantmanagementsystem;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class Item {
    private long id;
    private String name;
    private long price;
    private Category category;
    private List<String> ingredients;
}
