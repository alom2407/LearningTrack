package code.practice.concepts.threads;

import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        //fixedThreadPoolExample();
        //cachedThreadPoolExample();
        scheduleTreadPoolExample();
    }

    public static void scheduleTreadPoolExample(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        Runnable task = ()->{
            System.out.println("This is a scheduled task");
        };
        scheduler.schedule(task , 5 , TimeUnit.SECONDS);
        scheduler.shutdown();

    }
    public static  void singleThreadPoolExample(){
        //  A thread pool with only one thread that executes tasks sequentially.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Task 1"));
        executor.execute(() -> System.out.println("Task 2"));
        executor.shutdown();
    }
    public static void cachedThreadPoolExample(){
        //A pool that creates new threads as needed
        // but reuses previously created threads if they are available.
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            executorService.execute(()->{
                System.out.println("Task"+ finalI +" "+Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
    public static void fixedThreadPoolExample(){
        //Types of thread pool
        //Fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            int finalI = i;
            Runnable worker = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Task"+ finalI);
                }
            };
            executorService.execute(worker);
        }
        executorService.shutdown();
    }
}
