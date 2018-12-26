package synhronization.demo1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();
        System.out.println("Pres return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}
