package multithreading;

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Runnable task = resource::accessResource;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3"); // Has to wait

        t1.start();
        t2.start();
        t3.start();
    }
}