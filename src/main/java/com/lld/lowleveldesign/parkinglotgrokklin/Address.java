package com.lld.lowleveldesign.parkinglotgrokklin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int zip_code;
    private String country;

}
