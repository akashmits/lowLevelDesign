package com.lld.lowleveldesign.designpattern.abstractfactory;

public class TestAbstractDesignPattern {
    public static void main(String [] args){
        testAbstractFactory();
    }

    private static void testAbstractFactory(){
        Computer pc= ComputerFactory.getComputer(new PCFactory("2 GB","500 GB", "4 core"));
        Computer server= ComputerFactory.getComputer(new ServerFactory("64 GB","5000 GB", "32 core"));
        Computer laptop= ComputerFactory.getComputer(new LaptopFactory("8 GB","500 GB", "16 core"));


        System.out.println("PC configuration:"+pc);
        System.out.println("Server Configuration :"+server);
        System.out.println("Laptop Configuration :"+laptop);

    }
}
