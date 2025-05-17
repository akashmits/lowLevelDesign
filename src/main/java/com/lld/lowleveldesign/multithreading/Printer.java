package com.lld.lowleveldesign.multithreading;

public class Printer {

//    The wait, notify, and notifyAll methods are placed in the Object class because they are fundamentally used for inter-thread communication based on object locks, meaning that any object can act as a synchronization point for threads waiting on a specific condition, making it essential for every object to have access to these methods; essentially, the lock mechanism is associated with the object itself, not the thread.
//    Key points:
//    Object-level synchronization:
//    Since every object in Java inherits from Object, placing these methods here allows any object to be used as a synchronization point for threads waiting on a specific condition related to that object.
//    Monitor concept:
//    Each object in Java has an associated "monitor" (lock) which is used to manage thread access. The wait, notify, and notifyAll methods operate on this monitor, allowing threads to wait on a condition related to the object and be notified when that condition changes.
//    Thread communication:
//    By having these methods in the Object class, multiple threads can effectively communicate with each other by waiting on and signaling conditions related to a shared object.

    private volatile boolean isOdd;
    public synchronized void printEven(int number){
        while(!isOdd){
            try{
                System.out.println("Wait clause for print Even ");
                wait();
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+number);
        isOdd=false;
        notify();
    }
    public synchronized void printOdd(int number){
        while(isOdd){
            try{
                System.out.println("Wait clause for print odd ");
                wait();
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+number);
        isOdd=true;
        notify();
    }

}
