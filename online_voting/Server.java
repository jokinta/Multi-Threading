package online_voting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Server {
    static LinkedList<Potrebitel> potrebiteli = new LinkedList<>();
    static LinkedList<Citizen> citizens = new LinkedList<>();
    static HashMap<Integer,Integer> canditatesVotes = new HashMap<>();
    static String[] candidates;
    public static void main(String[] args){
        ServerSocket ss;
        try {
            ss=new ServerSocket(5000);
        }catch (IOException e){
            System.out.println("WARNING Start server");
            return;
        }
        while (true){
            try {
                Socket socket = ss.accept();
                HelpingThread thread = new HelpingThread(socket);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
