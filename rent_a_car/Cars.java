package rent_a_car;

public class Cars {
   private String id;
   private String model;
   private String city;
   private String pricePerDay;
   private String date;

    public Cars(String id, String model, String city, String pricePerDay, String date) {
        this.id = id;
        this.model = model;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date+="/"+date;
    }
    public void carIsBack(String date) {
        this.date=this.date.replace(date,"");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId())
                .append(" ")
                .append(getModel())
                .append(" ")
                .append(getCity())
                .append(" ")
                .append(getPricePerDay())
                .append(" ")
                .append(getDate());
        return sb.toString();
    }
}
