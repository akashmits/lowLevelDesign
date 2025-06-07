package com.lld.lowleveldesign.designpattern.behavorial.observer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    String customerName;
    String customerMobileNo;
    String customerEmail;
}
