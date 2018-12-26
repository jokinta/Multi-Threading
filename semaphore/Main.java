package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i <200 ; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Connection.getInstance().connect();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

        }
        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.DAYS);



        /*Semaphore sem = new Semaphore(0);
       sem.release();
        sem.acquire();
        System.out.println("Available permits: "+sem.availablePermits());*/
    }
}
