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
}
