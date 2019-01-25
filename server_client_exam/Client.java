package server_client_exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("localhost", 6000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                System.out.println(dis.readUTF());
                String toSend = scanner.nextLine();
                dos.writeUTF(toSend);
                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connectrion:  " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                String recived = dis.readUTF();
                System.out.println(recived);

            }
            scanner.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
