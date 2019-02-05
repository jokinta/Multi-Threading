package I_preparation_for_exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentThread extends Thread {
    Socket socket;

    StudentThread(Socket socket) {
        this.socket = socket;
    }

    public void run

    {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
            out.writeUTF("Send doc type");
            out.flush();
            try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                String doctype = in.readUTF();
                if (doctype.equals("normal") || doctype.equals("special")) {
                    out.writeUTF("OK");
                    out.flush();
                } else {
                    out.writeUTF("BAD TYPE");
                    out.flush();
                    this.socket.close();
                    return;
                }
                Document doc = (Document) in.readObject();
                if (doctype.equals("normal")) {
                    synchronized (Server.specialDock.add(doc)) {
                    }
                    System.out.println("New special document saved");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Client sent invalid object");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

