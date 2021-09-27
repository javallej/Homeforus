package main.java.homeforus.core;

public class HouseListObject {

    private int house_id;
    private int realtor_id;
    private String realtor_username;
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
    private int days_listed;

    public void setHouseID(int House_id) {
        this.house_id = House_id;
    }

    public int getHouseID() {
        return this.house_id;
    }
    
    public void setRealtorID(int Realtor_id) {
        this.realtor_id = Realtor_id;
    }

    public int getRealtorID() {
        return this.realtor_id;
    }
    
    public void setRealtorUsername(String Realtor_username) {
        this.realtor_username = Realtor_username;
    }

    public String getRealtorUsername() {
        return this.realtor_username;
    }
    
    public void setState(String State) {
        this.state = State;
    }

    public String getState() {
        return this.state;
    }
    
    public void setCity(String City) {
        this.city = City;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setZip(String Zip) {
        this.zip = Zip;
    }

    public String getZip() {
        return this.zip;
    }
    
    public void setStreet(String Street) {
        this.street = Street;
    }

    public String getStreet() {
        return this.street;
    }
    
    public void setHouseNumber(int House_number) {
        this.house_number = House_number;
    }

    public int getHouseNumber() {
        return this.house_number;
    }
    
    public void setYear(int Year) {
        this.year = Year;
    }

    public int getYear() {
        return this.year;
    }
    
    public void setCost(int Cost) {
        this.cost = Cost;
    }

    public int getCost() {
        return this.cost;
    }
    
    public void setNumFloors(int Num_floors) {
        this.num_floors = Num_floors;
    }

    public int getNumFloors() {
        return this.num_floors;
    }
    
    public void setNumBed(int Num_bed) {
        this.num_bed = Num_bed;
    }

    public int getNumBed() {
        return this.num_bed;
    }
    
    public void setNumBath(int Num_bath) {
        this.num_bath = Num_bath;
    }

    public int getNumBath() {
        return this.num_bath;
    }
    
    public void setSqrFeet(int Sqr_feet) {
        this.sqr_feet = Sqr_feet;
    }

    public int getSqrFeet() {
        return this.sqr_feet;
    }
    
    public void setDaysListed(int Days_listed) {
        this.days_listed = Days_listed;
    }

    public int getDaysListed() {
        return this.days_listed;
    }
}
