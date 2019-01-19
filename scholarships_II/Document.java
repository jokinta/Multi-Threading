package scholarships_II;

public class Document {

	private String name;
	private double avgGrade;
	private double avgIncome;
	private String faculty;
	private boolean special;
	
	public Document(String name,double avgGrade,double avgIncome,String faculty,boolean special){
		this.name = name;
		this.avgGrade = avgGrade;
		this.avgIncome = avgIncome;
		this.faculty = faculty;
		this.special = special;
	}
	
	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public double getAvgIncome() {
		return avgIncome;
	}

	public void setAvgIncome(double avgIncome) {
		this.avgIncome = avgIncome;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
