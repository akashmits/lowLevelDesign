package com.lld.lowleveldesign.multithreading;

public class PrintOddEven {
    public static void main(String [] arg){
        Printer print= new Printer();
        Thread t1= new Thread(new TaskEvenOdd(print,10,false),"Odd");
        Thread t2= new Thread(new TaskEvenOdd(print,10,true),"Even");


        t2.start();
        t1.start();


    }
}
