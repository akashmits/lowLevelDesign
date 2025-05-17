package multithreading;

import java.util.concurrent.Semaphore;

class SharedResource {
    private final Semaphore semaphore = new Semaphore(2); // Allow max 2 threads at a time

    public void accessResource() {
        try {
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " is accessing the resource."+" | Time :"+System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}