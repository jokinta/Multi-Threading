package I_preparation_for_exam;

import semaphore.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

public class Server {
    final static LinkedList<Document> normalDocks = new LinkedList<>();
    final static LinkedList<Document> specialDock = new LinkedList<>();
    final static HashMap<String,Integer> odobreni = new HashMap<>();
    public static void main(String[] args) {
        ConnectionThread student;
        ConnectionThread secretariest;
        try {
            student = new ConnectionThread(5000,true);
            secretariest = new ConnectionThread(5001,false);
        }catch (IOException e){
            System.out.println("Can't start server");
            return;
        }
        student.start();
        secretariest.start();
        ServerSocket ss;
        try {
            ss = new ServerSocket(5000);
        }catch (IOException e){
            System.out.println("WARNING: Odobreni service failed to start!!!");
            return;
        }
        while (true){
            try(Socket socket = ss.accept()){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeUTF("Please send your password");
                out.flush();
                String usertype = in.readUTF();
                if(!usertype.equals("secret")) {
                    out.writeUTF("Bad type. BYE");
                    out.flush();
                    continue;
                }
                out.writeUTF("OK");
                Document doc = (Document)in.readObject();
                System.out.println(doc);
            }catch (IOException e) {
                System.out.println("WARNING");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
