package com.lld.lowleveldesign.parkinglotgrokklin;

public class ParkingAttandant extends Account{
    public ParkingAttandant(String userName, String password, Person person, AccountStatus accountStatus) {
        super(userName, password, person, accountStatus);
    }

    public void processTicket(String ticketNumber){

    }
}
