package com.lld.lowleveldesign.pubsub;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IQueueMediatorImpl implements IQueueMediator{
    Map<String,List<Publisher>> topicPublisherList;
    Map<String,List<Subscriber>> topicSubscriberList;

    private IQueueMediatorImpl(){
        topicPublisherList = new ConcurrentHashMap<>();
        topicSubscriberList = new ConcurrentHashMap<>();
    }

    @Override
    public void subscriberTopic(String topic, String id, SubscriptionType subscriptionType) throws Exception {
        if(subscriptionType==null)
                throw new Exception("Invalid Subscription type");

        if(subscriptionType.equals(SubscriptionType.PUBLISHER)){
            List<Publisher> publisherList=topicPublisherList.get(topic);
        }

    }

    @Override
    public boolean sendMessage(String topic, String msg, long id) {
        return false;
    }

    @Override
    public String pullMessage(String topic, long id) {
        return null;
    }

    @Override
    public List<String> pullMessageInBatch(String topic, long id) {
        return null;
    }
}
