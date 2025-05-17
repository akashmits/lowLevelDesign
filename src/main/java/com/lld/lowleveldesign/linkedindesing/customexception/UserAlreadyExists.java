package com.lld.lowleveldesign.linkedindesing.customexception;

public class UserAlreadyExists extends Exception {

    public UserAlreadyExists(String message){
        super(message);
    }
}
