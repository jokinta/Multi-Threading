package interrupting_threads;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting...");
        ExecutorService executor = Executors.newCachedThreadPool();
       Future<?> fu= executor.submit(new Callable<Void>() {
            public Void call(){
                Random random = new Random();
                for (int i = 0; i <1E8 ; i++) {
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });
       executor.shutdown();
       Thread.sleep(500);
     //  fu.cancel(true);
       executor.awaitTermination(1,TimeUnit.DAYS);
        System.out.println("Finished.");
    }
}
