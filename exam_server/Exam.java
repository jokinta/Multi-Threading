package exam_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Exam extends Thread {
    private Socket socket;
    private String nameOfStudent;

    public Exam(Socket socket) {
        this.socket = socket;
    }


    public String getNameOfStudent() {
        return this.nameOfStudent;
    }

    public void run() {
        String toreturn;
        String answer;
        int correctAnswer = 0;
        int incorrectAnswers = 0;
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            this.nameOfStudent = dis.readUTF();
            dos.writeUTF("When it was the first world war?");
            answer= dis.readUTF();
            if (answer.equals("1941")) {
                dos.writeUTF("The answer is correct\n");
                correctAnswer++;
            } else {
                dos.writeUTF("Incorect answer");
                incorrectAnswers++;
            }
            dos.writeUTF("How many planets have the solar system\n");
            answer = dis.readUTF();
            if (answer.equals("8")) {
                dos.writeUTF("The answer is correct\n");
                correctAnswer++;
            } else {
                dos.writeUTF("Incorect answer");
                incorrectAnswers++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("You have ")
                    .append(correctAnswer)
                    .append(" correct answers. And ")
                    .append(incorrectAnswers)
                    .append(" incorrect answers.");

            dos.writeUTF(sb.toString());
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
