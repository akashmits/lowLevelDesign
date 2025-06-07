package com.lld.lowleveldesign.designpattern.behavorial.observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{

    private static Integer numberOfIphone=0;
    List<NotificationAlertObserver> subscriberList = new ArrayList<>();

    @Override
    public void add(NotificationAlertObserver alertObserver) {
        subscriberList.add(alertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver alertObserver) {
        subscriberList.remove(alertObserver);
    }

    @Override
    public void notifySubscribers() {
            for(NotificationAlertObserver alertObserver: subscriberList){
                alertObserver.update();
            }
    }

    @Override
    public void setStockData(Integer newStockAdded) {
        numberOfIphone +=newStockAdded;
        notifySubscribers();
    }

    @Override
    public void deleteStockData(Integer stockRemoved) throws Exception {
        if(numberOfIphone<stockRemoved)
            throw  new Exception(stockRemoved+" Iphones are not available");

        numberOfIphone-=stockRemoved;
    }

    @Override
    public int getStockCount() {
        return numberOfIphone;
    }
}
