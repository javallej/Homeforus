package main.java.homeforus.gui;

public class HouseInput {

    private String imageName;
    private String state;
    private String city;
    private String zip;
    private String street;
    private int house_number;
    private int cost;
    private int year;
    private int num_floors;
    private int num_bed;
    private int num_bath;
    private int sqr_feet;

    public HouseInput(String imageName, String state, String city, String zip, String street, int house_number,
                      int cost, int year, int num_floors, int num_bed, int num_bath, int sqr_feet) {
        this.imageName = imageName;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.house_number = house_number;
        this.cost = cost;
        this.year = year;
        this.num_floors = num_floors;
        this.num_bed = num_bed;
        this.num_bath = num_bath;
        this.sqr_feet = sqr_feet;
    }

    @Override
    public String toString() {
        return "HouseInput{" +
                "imageName='" + imageName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", street='" + street + '\'' +
                ", house_number=" + house_number +
                ", cost=" + cost +
                ", year=" + year +
                ", num_floors=" + num_floors +
                ", num_bed=" + num_bed +
                ", num_bath=" + num_bath +
                ", sqr_feet=" + sqr_feet +
                '}';
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum_floors() {
        return num_floors;
    }

    public void setNum_floors(int num_floors) {
        this.num_floors = num_floors;
    }

    public int getNum_bed() {
        return num_bed;
    }

    public void setNum_bed(int num_bed) {
        this.num_bed = num_bed;
    }

    public int getNum_bath() {
        return num_bath;
    }

    public void setNum_bath(int num_bath) {
        this.num_bath = num_bath;
    }

    public int getSqr_feet() {
        return sqr_feet;
    }

    public void setSqr_feet(int sqr_feet) {
        this.sqr_feet = sqr_feet;
    }
}
