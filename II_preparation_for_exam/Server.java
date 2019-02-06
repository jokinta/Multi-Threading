package II_preparation_for_exam;

import server_client_exam.Parking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    static final LinkedList<Cars> cars = new LinkedList<>();
    public static void main(String[] args) {
        ServerSocket ss;
        Socket socket;
        try {
            ss = new ServerSocket(5002);
        } catch (IOException e) {
            System.out.println("WARNING...");
            return;
        }
        while (true){
            try {
                socket = ss.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeUTF("How can we help you?");
                out.flush();
                String response = in.readUTF();
                System.out.println(response);
                ParkingService parking = new ParkingService(response,socket);
                parking.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

