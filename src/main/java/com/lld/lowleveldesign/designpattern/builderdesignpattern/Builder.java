package com.lld.lowleveldesign.designpattern.builderdesignpattern;

public interface Builder {
    public void reset();
    public void setSeat(int number);
    public void setEngine(int number);
    public void setTripComputer();
    public void setGPS();
}
