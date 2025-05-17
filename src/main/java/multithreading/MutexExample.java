package multithreading;

public class MutexExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Runnable task = resource::accessResource;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}