package I_preparation_for_exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SecretaruesThread extends Thread {
  private Socket socket;

    public SecretaruesThread(Socket socket){
        this.socket=socket;
    }

    public void run(){
        try(ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream())){
            out.writeUTF("Send you password");
            out.flush();
            try(ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream())){
                String userPass = in.readUTF();
                if(userPass.equals("secret")){
                    out.writeUTF("OK");
                    out.flush();
                    System.out.println("Secretary connected");
                }else {
                    out.writeUTF("Bad password");
                    out.flush();
                    this.socket.close();
                    System.out.println("Bad password for secretary connection");
                    return;
                }
                Document doc;
                synchronized (Server.specialDock){
                    if(Server.specialDock.isEmpty()){
                        out.writeUTF("special");
                        out.flush();
                        doc = Server.specialDock.getFirst();
                        out.writeObject(doc);
                        out.flush();
                        Server.specialDock.removeFirst();
                        System.out.println("Special doc sent to secretary");
                        return;
                    }
                }
                synchronized (Server.normalDocks){
                    if(Server.normalDocks.isEmpty()){
                        out.writeUTF("normal");
                        out.flush();
                        doc = Server.normalDocks.getFirst();
                        out.writeObject(doc);
                        out.flush();
                        Server.normalDocks.removeFirst();
                        System.out.println("Normal doc sent to secretary");
                        return;
                    }
                }
                out.writeUTF("NO DOCS");
                out.flush();
            }
        }catch (IOException ex){
            System.out.println("IO error with secretary: " + ex.getMessage());
        }
    }

}
