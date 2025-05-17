package com.lld.lowleveldesign.messageQueue;

public class Topic {
    private long id;
    private String topicName;
    private int currentProducerOffset;
    private int currentConsumerOffset;


    public Topic(String topicName){
        this.topicName=topicName;
        currentProducerOffset=0;
        currentConsumerOffset=0;
    }

}
