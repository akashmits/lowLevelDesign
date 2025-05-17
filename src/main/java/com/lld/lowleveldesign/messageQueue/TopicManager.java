package com.lld.lowleveldesign.messageQueue;

import com.lld.lowleveldesign.messageQueue.exceptionsHandler.InvalidTopic;

import java.util.HashMap;
import java.util.Map;

public class TopicManager {
    Map<String,Topic> topicMapping;

    public TopicManager(){
        this.topicMapping= new HashMap<>();
    }

    public boolean subscribeTopic(String topic){
        try{
            Topic topicDetails = topicMapping.get(topic);
            if(topicDetails==null){
                throw new InvalidTopic("Invalid Topic :"+topic);
            }
        }catch(Exception ex){

        }
        return false;
    }
}
