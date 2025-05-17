package com.lld.lowleveldesign.designpattern.abstractfactory;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
