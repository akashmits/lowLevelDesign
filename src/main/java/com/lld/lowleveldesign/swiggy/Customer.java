package com.lld.lowleveldesign.swiggy;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final String phone;


}
