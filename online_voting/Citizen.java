package online_voting;

public class Citizen {
    private String name;
    private String egn;
    private String adress;

    public Citizen(String name, String egn, String adress) {
        this.name = name;
        this.egn = egn;
        this.adress = adress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEgn() {
        return this.egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
