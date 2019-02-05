package I_preparation_for_exam;

import javax.print.Doc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vyvedete imeto si...");
        String name = scanner.nextLine();
        System.out.println("Vyvedete sredniq uspeh...");
        Double uspeh = Double.parseDouble(scanner.nextLine());
        System.out.println("Vyvedete dohod...");
        Double dohod = Double.parseDouble(scanner.nextLine());
        System.out.println("Vyvedete fakultet...");
        String fakultet = scanner.nextLine();
        System.out.println("Vyvedete tip na dokumenta...");
        String tip = scanner.nextLine();
        Document document = new Document(name,uspeh,dohod,fakultet,tip);
        Socket socket;
        try{
            socket = new Socket("localhost",5000);
        }catch (IOException e){
            System.out.println("Can't connect to server");
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
            System.out.println(in.readUTF());
            try(ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
                System.out.println("Programata isprashta tipa na dokumenta kym servera...");
                out.writeUTF(tip);
                out.flush();
                System.out.println("Gotovo");
                String response = in.readUTF();
                System.out.println(response);
                if(!response.equals("OK")){
                    System.out.println("Izpratihme nesyshtestvuvasht tip dokument");
                    return;
                }
                System.out.println("Programta isprashta dokumenta kym syrvyra....");
                out.writeObject(document);
                out.flush();
                System.out.println("Gotovo!");
            }


        } catch (IOException e){
            System.out.println(e.getMessage());
            return;
        }

    }
}
