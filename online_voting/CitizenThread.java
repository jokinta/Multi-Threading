package online_voting;

import java.io.*;
import java.net.Socket;

public class CitizenThread extends Thread {
    private Socket socket;
    private String egn;

    public CitizenThread(Socket socket,String egn){
        this.socket=socket;
        this.egn=egn;
    }
    public void run(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
            for (int i = 0; i <Server.citizens.size() ; i++) {
                if(Server.citizens.get(i).getEgn().equals(egn)){
                    out.writeUTF("You are already voted");
                    out.flush();
                    this.socket.close();
                }
            }
            for (int i = 0; i <Server.candidates.length ; i++) {
                out.writeInt(i);
                out.flush();
                out.writeUTF(Server.candidates[i]);
                out.flush();
            }
            String name = in.readUTF();
            String adress = in.readUTF();
            int votesChoice = in.readInt();
            Citizen citizen = new Citizen(name,adress,egn);
            Server.citizens.add(citizen);
            int votesForNow = Server.canditatesVotes.get(votesChoice)+1;
            Server.canditatesVotes.put(votesChoice,votesForNow);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
