package thread_server_client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
    public ServerThread() throws IOException {
    }

    public void run() {
        try {
            server();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void server() throws IOException, InterruptedException {

synchronized (this) {
    ServerSocket server = new ServerSocket(1211);
    Socket socket = server.accept();
    System.out.println("Socket accepted...");
    Scanner scanner = new Scanner(socket.getInputStream());
        System.out.println("Waiting for response");

    String name = scanner.nextLine();

    PrintStream printout = new PrintStream(socket.getOutputStream());

    System.out.println(name);


         }
    }

}
