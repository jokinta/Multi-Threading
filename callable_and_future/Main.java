package callable_and_future;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
       Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public  Integer call()throws Exception{
                Random random = new Random();
                int duration = random.nextInt(4000);
                System.out.println("Starting...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
                return duration;
            }
        });
       executor.shutdown();
        System.out.println("Result is: "+future.get());
    }
}
