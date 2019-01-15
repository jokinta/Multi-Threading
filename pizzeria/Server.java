package pizzeria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                System.out.println("A new client is connected");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                Thread thread = new Pizzeria(s,dis,dos);
                thread.start();
            } catch (Exception e) {
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
