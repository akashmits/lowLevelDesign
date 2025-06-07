package com.lld.lowleveldesign.designpattern.behavorial.observer;

public class MainObserverDesignPattern {
    public static void main(String[] args) {
        Customer c1 = Customer.builder().customerName("Akash").customerEmail("akash@gmail.com").customerMobileNo("8800910515")
                .build();
        Customer c5 = Customer.builder().customerName("Akash1").customerEmail("akash1@gmail.com").customerMobileNo("8800910516")
                .build();
        Customer c2 = Customer.builder().customerName("Akash2").customerEmail("akash2@gmail.com").customerMobileNo("8800910517")
                .build();
        Customer c3 = Customer.builder().customerName("Akas3").customerEmail("akash3@gmail.com").customerMobileNo("8800910518")
                .build();
        Customer c4 = Customer.builder().customerName("Akash4").customerEmail("akash4@gmail.com").customerMobileNo("8800910519")
                .build();

        StocksObservable iphoneObservable = new IphoneObservableImpl();
        iphoneObservable.setStockData(6);

        MobileAlertObservableImpl mmobileAlertObservable = new MobileAlertObservableImpl(iphoneObservable);
        EmialNotificationAlertObserver emailAlertObserver = new EmialNotificationAlertObserver(iphoneObservable);

        mmobileAlertObservable.addSubscribers(c1);
        mmobileAlertObservable.addSubscribers(c2);
        mmobileAlertObservable.addSubscribers(c3);

        emailAlertObserver.addSubscribers(c4);
        emailAlertObserver.addSubscribers(c5);

        iphoneObservable.add(mmobileAlertObservable);
        iphoneObservable.add(emailAlertObserver);

        iphoneObservable.setStockData(1);





    }
}
