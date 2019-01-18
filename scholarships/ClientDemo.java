import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String args[]) throws IOException, InterruptedException {
        Socket s = new Socket("localhost",6000);

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(s.getInputStream());
        PrintStream printout = new PrintStream(s.getOutputStream());




        try {
            System.out.println("Enter name: ");
            String nameofStudent = scan.nextLine();
            printout.println(nameofStudent);
            System.out.println("Enter rating: ");
            double rating = scan.nextDouble();
            printout.println(rating);
            System.out.println("Enter amount: ");
            double amount = scan.nextDouble();
            printout.println(amount);
            String input = scan2.nextLine();
            System.out.println(input);
        } catch (InputMismatchException e) {
            System.out.println("Enter a correct value");
        } finally {
            if (s != null)
                s.close();
            if (scan != null)
                scan.close();
            if (scan2 != null)
                scan2.close();
        }

}

}