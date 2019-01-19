package scholarships_II;

import java.util.LinkedList;

public class Secretary {
	private Document doc;
	private LinkedList<Document> approvedDocs;
	private LinkedList<Document> declinedDocs;
	
	public Secretary(Document doc,LinkedList<Document> approvedDocs,LinkedList<Document> declinedDocs){
		this.doc = doc;
		this.approvedDocs = approvedDocs;
		this.declinedDocs = declinedDocs;
	}
	
	synchronized public void processDocument(){
		if(doc.isSpecial()){
			if(doc.getAvgGrade() > 5.30 && doc.getAvgIncome() < 300){
				int normalCount = 0;
				int specialCount = 0;
				
				for(Document apprDoc : approvedDocs){
					if(apprDoc.getName().equals(doc.getName())){
						if(apprDoc.isSpecial()){
							specialCount++;
						}
						else{
							normalCount++;
						}
					}
				}
				
				if(normalCount == 0 && specialCount >= 4){
					declinedDocs.add(doc);
				}
				
				if(normalCount >= 1 && specialCount >= 5){
					declinedDocs.add(doc);
				}
				
				approvedDocs.add(doc);
			}
			else{
				declinedDocs.add(doc);
			}
		}
		else{
			if(doc.getAvgGrade() > 5.50 && doc.getAvgGrade() < 500){
				
				for(Document apprDoc : approvedDocs){
					if(apprDoc.getName().equals(doc.getName())){
						if(!apprDoc.isSpecial()){
							declinedDocs.add(doc);
							return;
						}
					}
				}
				
				approvedDocs.add(doc);
			}
			else{
				declinedDocs.add(doc);
			}
		}
	}
}
