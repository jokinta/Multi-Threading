package exam_server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket socket;
        while (true)
        {
            try {
                System.out.println("Waiting for new client...");
                socket = ss.accept();
                System.out.println("A new client is conected");
                Thread thread = new Exam(socket);
                thread.start();



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
