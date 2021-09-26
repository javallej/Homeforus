package main.java.homeforus.core;

public class RealtorListObject {

    private int realtor_id;
    private String realtor_username;
    private String business_name;
    
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
    
    public void setRealtorBusinessName(String Business_Name) {
        this.business_name = Business_Name;
    }

    public String getRealtorBusinessName() {
        return this.business_name;
    }
}
