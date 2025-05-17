package com.lld.lowleveldesign.messageQueue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Producer {
    long producerId;
    Topic  topic;

    public Producer(long producerId,String topicName){
        this.producerId=producerId;
        this.topic=new Topic(topicName);
    }



    public boolean sendData(String s){
        return false;
    }

}
