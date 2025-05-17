package multithreading;

public class ContextSwitchExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask("Task 1", 50));
        Thread t2 = new Thread(new MyTask("Task 2", 100));
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("An error occurred in thread execution.");
        }
    }
}