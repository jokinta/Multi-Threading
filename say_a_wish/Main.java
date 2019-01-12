package say_a_wish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("What is your wish");
        answer=bf.readLine();
        thread.access();


    }
}

