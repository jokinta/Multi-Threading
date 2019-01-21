package exam_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5000);
            Scanner scanner = new Scanner(System.in);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Enter your name to start...");
            String name = scanner.nextLine();
            dos.writeUTF(name);
            while(true) {
                String response = dis.readUTF();
                System.out.println(response);
                String answer = scanner.nextLine();
                dos.writeUTF(answer);
                String response2 = dis.readUTF();
                System.out.println(response2);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
