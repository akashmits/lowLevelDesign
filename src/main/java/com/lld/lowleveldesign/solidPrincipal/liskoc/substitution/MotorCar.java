package com.lld.lowleveldesign.solidPrincipal.liskoc.substitution;

public class MotorCar implements  Car{

    private Engine engine;
    @Override
    public void turnOnEngine() {
        engine.on();
    }

    @Override
    public void accelerate() {
        engine.powerOn(1000);
    }
}
