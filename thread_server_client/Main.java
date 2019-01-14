package thread_server_client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerThread thread = new ServerThread();
        ClientThread thread1 = new ClientThread();

            Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread1);
            t1.start();
            t2.start();


    }
}
