package server_client_exam;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Cars extends Thread{
    Queue<Parking> parking = new LinkedList();

    private Socket socket;
   private DataInputStream dis;
   private DataOutputStream dos;

    public Cars(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run(){
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos =new DataOutputStream(socket.getOutputStream());
            String recived = dis.readUTF();
            String parts [] = recived.split(" ");
            Parking car = new Parking(parts[0],parts[1],Double.parseDouble(parts[2]));
            parking.add(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
