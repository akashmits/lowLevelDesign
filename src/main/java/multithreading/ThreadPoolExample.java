package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String [] arg){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for(int i=0;i<20;i++){
            final int taskId = i;
            // Submits tasks to the thread pool
            threadPool.submit(() -> System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName()));
        }

        // Shuts down the thread pool
        threadPool.shutdown();
    }
}
