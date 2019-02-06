package II_preparation_for_exam;

import java.util.Scanner;

public class AvailableCars{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cars car1 = new Cars(1,"Opel","Corsa","Sofia",50,"18.01.2019");
        Cars car2 = new Cars(2,"Fiat","Bravo","Varna",100,"");
        Server.cars.add(car1);
        Server.cars.add(car2);
        String name = scanner.nextLine();

    }
}
