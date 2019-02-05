package I_preparation_for_exam;

public class Document {
    private String name;
    private double uspeh;
    private double dohod;
    private String faculted;
    private String type;

    public Document(String name, double uspeh, double dohod, String faculted, String type) {
        this.name = name;
        this.uspeh = uspeh;
        this.dohod = dohod;
        this.faculted = faculted;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUspeh() {
        return this.uspeh;
    }

    public void setUspeh(double uspeh) {
        this.uspeh = uspeh;
    }

    public double getDohod() {
        return this.dohod;
    }

    public void setDohod(double dohod) {
        this.dohod = dohod;
    }

    public String getFaculted() {
        return this.faculted;
    }

    public void setFaculted(String faculted) {
        this.faculted = faculted;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
