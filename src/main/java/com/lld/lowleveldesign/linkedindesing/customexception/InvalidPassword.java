package com.lld.lowleveldesign.linkedindesing.customexception;

public class InvalidPassword extends Exception{
    public InvalidPassword(String msg){
        super(msg);
    }
}
