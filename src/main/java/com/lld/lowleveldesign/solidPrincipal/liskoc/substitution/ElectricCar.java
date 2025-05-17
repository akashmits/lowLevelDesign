package com.lld.lowleveldesign.solidPrincipal.liskoc.substitution;

public class ElectricCar implements Car{
    @Override
    public void turnOnEngine() {
        throw new AssertionError("I don't have Engine.");
    }

    @Override
    public void accelerate() {

    }
}
