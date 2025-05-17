package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    public Lock lock1 = new ReentrantLock();
    public Lock lock2 = new ReentrantLock();


    public void method1() {
        lock1.lock();
        System.out.println("Method 1 : Resourece 1 lock acquire");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException esx) {
            System.err.println("Interrupted exception");
        }

        lock2.lock();

        System.out.println("Resource 2 lock acquire");

        lock1.unlock();
        lock2.unlock();
    }


    public void method2() {
        lock2.lock();
        System.out.println("Method2: Resourece 2 lock acquire");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException esx) {
            System.err.println("Interrupted exception");
        }

        lock2.lock();

        System.out.println("Method2: Resource 1 lock acquire");

        lock2.unlock();
        lock1.unlock();
    }

    public  static void main(String [] arg) {
        DeadLock example = new DeadLock();

        Thread t1 = new Thread(example::method1);
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }

}
