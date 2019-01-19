package scholarships_II;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Student {




		private Socket client;
		private LinkedList<Document> documents;


	public Student(Socket client, LinkedList<Document> documents) {
			this.client = client;
			this.documents = documents;
		}

		public void collectData() {
			PrintStream print = null;
			Scanner scan = null;
			try {
				print = new PrintStream(client.getOutputStream());
				scan = new Scanner(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name;
			double income;
			double grade;
			String faculty;
			boolean special;
			String typeStr;

			print.println("Enter your name");
			name = scan.nextLine();

			print.println("Enter avg grade");
			grade = scan.nextDouble();

			print.println("Enter monthly income per family member");
			income = scan.nextDouble();

			print.println("Enter faculty");
			faculty = scan.nextLine();

			print.println("Is it special");
			typeStr = scan.nextLine();

			if (typeStr.equals("yes")) {
				special = true;
			} else {
				special = false;
			}

			synchronized (documents) {
				Document doc = new Document(name, grade, income, faculty, special);
				documents.add(doc);
			}


	}
}
