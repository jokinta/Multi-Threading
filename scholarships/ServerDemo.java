package scholarships;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServerDemo {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6000);

        while (true) {


            Socket socket = null;
            try {
                System.out.println("Waiting for client...");
                socket = ss.accept();
                System.out.println("A new client is connected");
                Scanner sc = new Scanner(socket.getInputStream());
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                String nameofStudent = sc.nextLine();
                double rating = Double.parseDouble(sc.nextLine());
                double amount = Double.parseDouble(sc.nextLine());
                System.out.printf("%s - %f - %f\n",nameofStudent,rating,amount);
                Thread thread = new Office(socket,nameofStudent, rating, amount);
                thread.start();
            }  catch(Exception e){
                    try {
                        socket.close();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }


            }
        }
    }

