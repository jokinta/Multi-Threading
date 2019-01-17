package rent_a_car;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class Garage extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public Garage(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        int function;
        Cars car=null;
        try {


            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Jokinta\\IdeaProjects\\Thread\\src\\rent_a_car\\Parking.txt"));
            BufferedWriter buffer = new BufferedWriter(new FileWriter("C:\\Users\\Jokinta\\IdeaProjects\\Thread\\src\\rent_a_car\\Parking.txt",true));
            PrintWriter writer = new PrintWriter(buffer);
            while (true) {

                StringBuilder menu = new StringBuilder();
                     menu.append("1: Tyrsena na koli v opredelen grad\n")
                        .append("2: Vzimane na kola za opredelena data\n")
                        .append("3: Ostavqne na kolata v opredelen grad\n")
                        .append("Izberete edna ot funkciite...\n");
                    dos.writeUTF(menu.toString());

                received = dis.readUTF();
                String[] parts = received.split(" ");


                function = Integer.parseInt(parts[0]);
                switch (function) {
                    case 1:

                        String city = parts[1];
                        String currentLine;

                        while ((currentLine = reader.readLine()) != null) {
                            String[] parts2 = currentLine.split(" ");
                            if (city.equals(parts2[2])) {
                                dos.writeUTF(parts2[1]);
                            }
                        }
                    case 2:
                        String id = (parts[1]);
                        String date = parts[2];
                        while ((currentLine = reader.readLine()) != null) {
                            String[] parts2 = currentLine.split(" ");
                            if (id.equals(parts2[0])) {
                                  car=new Cars(parts2[0],parts2[1],parts2[2],parts2[3],parts2[4]);
                                if (parts2[4].contains(date)) {
                                    dos.writeUTF("Kolata e rezervirana za tazi data");
                                    break;
                                } else {


                                    car.setDate(date);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Vie rezervirahte kola: ")
                                            .append(parts2[1])
                                            .append("-Za period: ")
                                            .append(date);
                                    dos.writeUTF(sb.toString());
                                    writer.println(car);
                                    writer.close();

                                }

                            }
                        }
                        break;
                    case 3:
                        id = parts[1];
                        city = parts[2];
                       String returnDate=parts[3];
                        while ((currentLine = reader.readLine()) != null) {
                            String[] parts2 = currentLine.split(" ");
                            if(id.equals(parts2[0])) {
                                car = new Cars(parts2[0], parts2[1], parts2[2], parts2[3], parts2[4]);
                                car.carIsBack(returnDate);
                                car.setCity(city);
                                StringBuilder sb = new StringBuilder();
                                sb.append("Vie ostabihte kola: ")
                                        .append(parts2[1])
                                        .append("-V grad: ")
                                        .append(city);
                                writer.println(car);
                                writer.close();
                                dos.writeUTF(sb.toString());
                            }
                            }


                    default:
                        dos.writeUTF("Incorect input...Try again");
                }
            }

            } catch(FileNotFoundException e1){
                e1.printStackTrace();
            } catch(IOException e1){
                e1.printStackTrace();
            }

    }
    }
