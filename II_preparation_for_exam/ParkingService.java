package II_preparation_for_exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ParkingService extends Thread {
    private String response;
    private Socket socket;

    public ParkingService(String response,Socket socket){
        this.response = response;
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
            String[] parts = this.response.split("-");
            if (Integer.parseInt(parts[0])==1) {
                out.writeUTF("Nqma koli v "+parts[1]);
                out.flush();
                String available = null;
                for (int i = 0; i < Server.cars.size(); i++) {
                    if (Server.cars.get(i).getCity().equals(parts[1])) {
                        available += Server.cars.get(i).getModel();

                    }else out.writeUTF("Nqma koli v "+parts[1]);
                    out.flush();
                }
                out.writeUTF(available);
                out.flush();
            } else if (parts[0].equals("2")) {
                for (int i = 0; i < Server.cars.size(); i++) {
                    if (Server.cars.get(i).getId() == (Integer.parseInt(parts[1]))) {
                        if (Server.cars.get(i).getDate().contains(parts[2])) {
                            out.writeUTF("Kolata e zaeta");
                            out.flush();
                        } else Server.cars.get(i).setDate(parts[2]);
                    }
                }
            } else if (parts[0].equals("3")) {
                for (int i = 0; i < Server.cars.size(); i++) {
                    if (Server.cars.get(i).getId() == (Integer.parseInt(parts[1]))) {
                        Server.cars.get(i).setCity(parts[2]);
                        Server.cars.get(i).returnCar();
                    }

                }
            }
        }catch (IOException e){
            e.getMessage();
        }
    }
}
