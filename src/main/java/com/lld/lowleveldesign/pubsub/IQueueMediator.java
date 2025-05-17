package com.lld.lowleveldesign.pubsub;

import java.util.List;

public interface IQueueMediator {
    public void subscriberTopic(String topic,String id, SubscriptionType subscriptionType) throws Exception;
    public boolean sendMessage(String topic,String msg,long id);
    public String pullMessage(String topic,long id);
    public List<String> pullMessageInBatch(String topic, long id);
}
