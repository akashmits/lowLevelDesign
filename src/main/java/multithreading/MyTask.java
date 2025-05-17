package multithreading;

class MyTask implements Runnable {
    private String name;
    private int delay;

    public MyTask(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is running.");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task " + name + " was interrupted.");
        }
        System.out.println("Task " + name + " completed.");
    }
}