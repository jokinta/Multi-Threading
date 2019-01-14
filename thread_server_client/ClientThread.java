package thread_server_client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {
    public void run() {
        try {
            client();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void client() throws IOException {
            synchronized (this) {
                Socket socket = new Socket("127.0.0.1", 1211);
                Scanner sc1 = new Scanner(System.in);
                Scanner sc2 = new Scanner(socket.getInputStream());
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                System.out.println("Enter message:");
                String print = sc1.nextLine();
                printStream.println(print);
                String inbox = sc2.nextLine();
            }

    }
}
