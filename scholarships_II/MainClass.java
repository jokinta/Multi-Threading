package scholarships_II;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9890);
		
		LinkedList<Document> pendingDocuments = new LinkedList<Document>();
		LinkedList<Document> approvedDocs = new LinkedList<Document>();
		LinkedList<Document> declinedDocs = new LinkedList<Document>();
		
		while(true){
			System.out.println("Wait for client");
			Socket client = server.accept();
			
			System.out.println("Client connected");
			ServerThread th = new ServerThread(client, pendingDocuments, approvedDocs, declinedDocs);
			
			th.start();
		}

	}

}
