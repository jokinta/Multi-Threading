package online_voting;

public class Potrebitel {
    private String egn;
    private Boolean citizen;

    public Potrebitel(String egn, Boolean citizen) {
        this.egn = egn;
        this.citizen = citizen;
    }

    public String getEgn() {
        return this.egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public Boolean isCitizen() {
        return this.citizen;
    }

    public void setCitizen(Boolean citizen) {
        this.citizen = citizen;
    }
}
