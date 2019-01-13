package it_academy_example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

            MyThread mythread = new MyThread(false);

            mythread.start();
            Thread.sleep(3000);
            mythread.stopThread();


      //  System.out.println("Active threads: " + Thread.activeCount());
    }
}
