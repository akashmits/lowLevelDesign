package com.lld.lowleveldesign.designpattern.behavorial.observer;

public interface NotificationAlertObserver {

    public void addSubscribers(Customer subscriber);
    public void removeSubscriber(Customer subscriber);
    public void update();


}
