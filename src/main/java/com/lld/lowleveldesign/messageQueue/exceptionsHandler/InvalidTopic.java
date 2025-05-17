package com.lld.lowleveldesign.messageQueue.exceptionsHandler;

public class InvalidTopic extends Exception{
    String desc;

    public InvalidTopic(String desc){
        this.desc=desc;

    }


}
