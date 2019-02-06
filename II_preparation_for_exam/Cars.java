package II_preparation_for_exam;

public class Cars {
    private int id;
    private String brand;
    private String model;
    private String city;
    private double pricePerDay;
    private String date;

    public Cars(int id, String brand, String model, String city, double pricePerDay, String date) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
        this.city = this.city + city;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void returnCar(){
        this.city=null;
    }
}
