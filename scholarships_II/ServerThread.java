package scholarships_II;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerThread extends Thread{
	private Socket client;
	private LinkedList<Document> pendingDocuments;
	private LinkedList<Document> approvedDocs;
	private LinkedList<Document> declinedDocs;
	
	public ServerThread(Socket client,LinkedList<Document> pendingDocuments,LinkedList<Document> approvedDocs,LinkedList<Document> declinedDocs){
		this.client = client;
		this.pendingDocuments = pendingDocuments;
		this.approvedDocs = approvedDocs;
		this.declinedDocs = declinedDocs;
	}
	
	@Override
	public void run(){
		PrintStream print = null;
		Scanner scan = null;
		try {
			print = new PrintStream(client.getOutputStream());
			scan = new Scanner(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		print.println("Enter user level");
		
		String str = scan.nextLine();
		
		if(str.equals("student")){
			Student stud = new Student(client, pendingDocuments);
			stud.collectData();
		}
		else if(str.equals("secretary")){
			if(pendingDocuments.isEmpty()) return;
			
			Document doc = pendingDocuments.poll();
			
			Secretary secretary = new Secretary(doc, approvedDocs, declinedDocs);
			secretary.processDocument();
		}
		else{
			print.println("Invalid user");
		}
		
		print.println("done");
		
		print.close();
		scan.close();
	}
}
