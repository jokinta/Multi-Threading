package I_preparation_for_exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Secretary {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 5001);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        System.out.println(in.readUTF());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeUTF("secret");
        out.flush();
        String passOK = in.readUTF();
        if (!passOK.equals("OK")) {
            System.out.println("Bad password");
            return;
        }
        String doctype = in.readUTF();
        if (doctype.equals("NO DOCKS")) {
            System.out.println("Nqma dokumenti");
            return;
        }
        Document doc = (Document) in.readObject();
        if (doctype.equals("special")) {
            if (doc.getUspeh() < 5.30) {
                System.out.println("Po-nisyk uspeh za specialna molba na " + doc.getName() + ",Othvyrlen!");
            } else if (doc.getDohod() > 300.0) {
                System.out.println("Po-visok dohod za specialna molba na " + doc.getName() + "Othvyrlen!");
            } else {
                Socket socket2 = new Socket("localhost", 5002);
                ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
                out2.flush();
                ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
                System.out.println(in2.readUTF());
                out2.writeUTF("secret");
                String response = in2.readUTF();
                if (!response.equals("OK")) {
                    System.out.println("Bad password");
                    return;
                }
                out2.writeObject(doc);
                int odobreni = in2.readInt();
                if (odobreni > 5) {
                    System.out.println("Othvyrlena specialna molba na " + doc.getName() + " zaradi poveche ot 5 odovreni");
                } else System.out.println("Odobrena specialna molba na " + doc.getName());
            }
        } else if (doctype.equals("normal")) {
            if (doc.getUspeh() < 5.50) {
                System.out.println("Po-nisyk uspeh za normalna molba na " + doc.getName() + ",Othvyrlen!");
            } else if (doc.getDohod() > 500.0) {
                System.out.println("Po-visok dohod za normalna molba na " + doc.getName() + "Othvyrlen!");

            } else {
                Socket socket2 = new Socket("localhost", 5002);
                ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
                out2.flush();
                ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
                System.out.println(in2.readUTF());
                out2.writeUTF("secret");
                String response = in2.readUTF();
                if (!response.equals("OK")) {
                    System.out.println("Bad password");
                    return;
                }
                out2.writeObject(doc);
                int odobreni = in2.readInt();
                if (odobreni > 4) {
                    System.out.println("Othvyrlena normalna molba na " + doc.getName() + " zaradi poveche ot 4 odovreni");
                } else System.out.println("Odobrena normalna molba na " + doc.getName());
            }
        }
    }

}
