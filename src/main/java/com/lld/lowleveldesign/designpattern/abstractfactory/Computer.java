package com.lld.lowleveldesign.designpattern.abstractfactory;

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString() {
        return "Computer{}"+this.getRAM()+", HDD:{}"+this.getHDD()+", CPU:{}"+this.getCPU();
    }
}
