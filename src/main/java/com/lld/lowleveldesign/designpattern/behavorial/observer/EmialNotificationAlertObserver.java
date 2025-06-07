package com.lld.lowleveldesign.designpattern.behavorial.observer;

import java.util.HashSet;
import java.util.Set;

public class EmialNotificationAlertObserver implements  NotificationAlertObserver{
    StocksObservable observableEntity;
    Set<Customer> customerSubscribers = new HashSet<>();

    public EmialNotificationAlertObserver(StocksObservable observableEntity){
        this.observableEntity=observableEntity;
    }

    @Override
    public void addSubscribers(Customer subscriber) {
        customerSubscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Customer subscriber) {
        customerSubscribers.remove(subscriber);
    }

    @Override
    public void update() {
        if(observableEntity.getStockCount()>0){
            for(Customer customer:customerSubscribers){
                System.out.println("Email Sent to :"+customer.getCustomerEmail());
            }
        }
    }
}
