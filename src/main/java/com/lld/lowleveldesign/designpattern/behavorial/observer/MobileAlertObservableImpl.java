package com.lld.lowleveldesign.designpattern.behavorial.observer;

import java.util.HashSet;
import java.util.Set;

public class MobileAlertObservableImpl implements NotificationAlertObserver{

    StocksObservable observable;

    Set<Customer> customerSubscriberList = new HashSet<>();

    public MobileAlertObservableImpl(StocksObservable stocksObservable){
        this.observable=stocksObservable;
    }

    @Override
    public void addSubscribers(Customer subscriber) {
        customerSubscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Customer subscriber) {
        customerSubscriberList.remove(subscriber);
    }

    @Override
    public void update() {
            if(observable.getStockCount()>0){
                for(Customer customer: customerSubscriberList){
                    System.out.println("Mobile Alert Notification sent:"+customer.getCustomerMobileNo());
                }
            }
    }
}
