package server_client_exam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        while (true){
            System.out.println("Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client is connected");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Cars(socket);
            thread.start();


        }
    }
}
