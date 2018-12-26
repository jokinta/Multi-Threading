package starting_threads.demo3.demo3;

public class Main {
    public static void main(String[] args) {


    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println("Hello "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
        t1.start();

    }
}
