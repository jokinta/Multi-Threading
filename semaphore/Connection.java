package semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private Semaphore sem = new Semaphore(10,true);
    private int conections = 0;
    private Connection(){

    }
    public static Connection getInstance(){
        return instance;
    }
    public void connect() throws InterruptedException {
        sem.acquire();
        try {
            doconnect();
        }finally {
            sem.release();
        }

    }

    public void doconnect() throws InterruptedException {
        synchronized (this){
            conections++;
            System.out.println("Current conections: "+conections);
        }
        Thread.sleep(2000);
        synchronized (this){
            conections--;
        }
    }
}
