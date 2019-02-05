package I_preparation_for_exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionThread extends Thread {
   private ServerSocket ss;
   private boolean isStudentAccepter;

   public ConnectionThread(int port,boolean isStudentAccepter) throws IOException {
       this.ss = new ServerSocket(port);
       this.isStudentAccepter = isStudentAccepter;
   }

   public void run(){
       while (true){
           Socket socket;
           try {
               socket = this.ss.accept();
               Thread t;
               if(this.isStudentAccepter){
                   System.out.println("Student connected");
                   t = new StudentThread(socket);
               }else {
                   System.out.println("Secretary connected");
                   t = new SecretaruesThread(socket);
               }
               t.start();
           }catch (IOException e){
               System.out.println("New connection failure");
               return;
           }
       }
   }
}
