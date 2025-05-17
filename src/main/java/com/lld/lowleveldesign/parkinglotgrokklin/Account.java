package com.lld.lowleveldesign.parkinglotgrokklin;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {
    String userName;
    String password;
    Person person;
    AccountStatus accountStatus;


    public void resetPassWord(){

    }
}
