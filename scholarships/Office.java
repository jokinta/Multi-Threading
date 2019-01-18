package scholarships;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Office extends Thread {
    final Socket socket;
    private String nameofStudent;
    private double rating;
    private double amount;


    public Office(Socket socket,String nameofStudent, double rating, double amount){
        this.socket=socket;
        this.nameofStudent = nameofStudent;
        this.rating = rating;
        this.amount = amount;
    }

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
        if(getRating()>5 && getAmount()<500){
            printStream.println("Congratulations on your scholarship!");
        }
        else{
            printStream.println("Unfortunately you are not approved for a scholarship...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return this.socket;
    }

    public String getNameofStudent() {
        return this.nameofStudent;
    }

    public void setNameofStudent(String nameofStudent) {
        this.nameofStudent = nameofStudent;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
