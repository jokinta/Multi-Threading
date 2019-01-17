package rent_a_car;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(6070);

        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                System.out.println("A new client is connected..." + s);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                System.out.println("Assigning new thread for this client");
                Thread t = new Garage(s,dis,dos);
                t.start();
            }catch (Exception e){
                try {
                    s.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            }

        }

    }

