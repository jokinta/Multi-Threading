package online_voting;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HelpingThread extends Thread {
   private Socket socket;

   public HelpingThread(Socket socket){
       this.socket=socket;
   }

   public void run(){
       try {
           ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream())
           ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
           out.writeUTF("Enter your egn");
           out.flush();
           String egn = in.readUTF();
           for (int i = 0; i <Server.potrebiteli.size() ; i++){
               if(Server.potrebiteli.get(i).getEgn().equals(egn)) {
                   if (Server.potrebiteli.get(i).isCitizen()) {
                       CitizenThread t = new CitizenThread(socket, egn);
                       t.start();
                   }
               }

               else {
                       out.writeUTF("REFUSED");
                       out.flush();
                   }
               }

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
