package server_client_exam;

import java.util.LinkedList;
import java.util.Queue;

public class Parking {
    private String carName;
    private String carModel;
    private double price;

    public Parking(String carName, String carModel, double price) {
        this.carName = carName;
        this.carModel = carModel;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", price=" + price +
                '}';
    }
}
