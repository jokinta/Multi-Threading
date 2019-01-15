package pizzeria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Pizzeria extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    public Pizzeria(Socket s, DataInputStream dis, DataOutputStream dos) {
        {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
        }

    }

    public void run() {
        String received;
        String toreturn;
        try {
            dos.writeUTF("What pizza you want?");
            received = dis.readUTF();
            switch (received) {
                case "capricciosa":
                    toreturn = "You need to wait about 10 minutes...";
                    dos.writeUTF(toreturn);
                    sleep(10000);
                    toreturn = "Your pizza is done!";
                    dos.writeUTF(toreturn);
                case "margherita":
                    toreturn = "You need to wait about 15 minutes...";
                    dos.writeUTF(toreturn);
                    sleep(15000);
                    toreturn = "Your pizza is done!";
                    dos.writeUTF(toreturn);
                case "capri":
                    toreturn = "You need to wait about 18 minutes...";
                    dos.writeUTF(toreturn);
                    sleep(28000);
                    toreturn = "Your pizza is done!";
                    dos.writeUTF(toreturn);
                case "victoria":
                    toreturn = "You need to wait about 20 minutes...";
                    dos.writeUTF(toreturn);
                    sleep(20000);
                    toreturn = "Your pizza is done!";
                    dos.writeUTF(toreturn);
                default:
                    toreturn = "We don't have that pizza";
                    dos.writeUTF(toreturn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


