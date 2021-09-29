/*
  File: HouseListObject.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Getter/Setter for listing of House from database.
*/


package main.java.homeforus.core;

/**
Class: HouseListObject 

Description: Getter/Setter for listing of House from database.
*/


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

    /**
    Method: setHouseID
    Inputs: int House_id
    Returns: void

    Description: Sets the House_ID.
  */
    public void setHouseID(int House_id) {
        this.house_id = House_id;
    }

    /**
    Method: getHouseID
    Inputs: void
    Returns: int

    Description: Gets the House_ID.
  */
    
    public int getHouseID() {
        return this.house_id;
    }
    
    /**
    Method: setRealtorID
    Inputs: int Realtor_id
    Returns: void

    Description: Sets the Realtor_ID.
  */
    public void setRealtorID(int Realtor_id) {
        this.realtor_id = Realtor_id;
    }

    /**
    Method: getRealtorID
    Inputs: void
    Returns: int

    Description: Gets the Realtor_ID.
  */
    public int getRealtorID() {
        return this.realtor_id;
    }
    
    /**
    Method: setRealtorUsername
    Inputs: String Realtor_username
    Returns: void

    Description: Sets the Realtor_Username.
  */
    
    public void setRealtorUsername(String Realtor_username) {
        this.realtor_username = Realtor_username;
    }

    /**
    Method: getRealtorUsername
    Inputs: void
    Returns: String

    Description: Gets the Realtor_Username.
  */
    public String getRealtorUsername() {
        return this.realtor_username;
    }
    
    /**
    Method: setState
    Inputs: String State
    Returns: void

    Description: Sets the State.
  */
    public void setState(String State) {
        this.state = State;
    }

    /**
    Method: getState
    Inputs: void
    Returns: String

    Description: Gets the State.
  */
    public String getState() {
        return this.state;
    }
    
    /**
    Method: setCity
    Inputs: String City
    Returns: void

    Description: Sets the City.
  */
    public void setCity(String City) {
        this.city = City;
    }

    /**
    Method: getCity
    Inputs: void
    Returns: String

    Description: Gets the City.
  */
    public String getCity() {
        return this.city;
    }
    
    /**
    Method: setZip
    Inputs: String Zip
    Returns: void

    Description: Sets the Zip.
  */
    public void setZip(String Zip) {
        this.zip = Zip;
    }

    /**
    Method: getZip
    Inputs: void
    Returns: String

    Description: Gets the Zip.
  */
    public String getZip() {
        return this.zip;
    }
    
    /**
    Method: setStreet
    Inputs: String Street
    Returns: void

    Description: Sets Street.
  */
    public void setStreet(String Street) {
        this.street = Street;
    }

    /**
    Method: getStreet
    Inputs: void
    Returns: String

    Description: Gets the Street
  */
    public String getStreet() {
        return this.street;
    }
    
    /**
    Method: setHouseNumber
    Inputs: int House_number
    Returns: void

    Description: Sets the House_Number.
  */
    public void setHouseNumber(int House_number) {
        this.house_number = House_number;
    }

    /**
    Method: getHouseNumber
    Inputs: void
    Returns: int

    Description: Gets the House_Number.
  */
    public int getHouseNumber() {
        return this.house_number;
    }
    
    /**
    Method: setYear
    Inputs: int Year
    Returns: void

    Description: Sets the Year.
  */
    public void setYear(int Year) {
        this.year = Year;
    }

    /**
    Method: getYear
    Inputs: void
    Returns: int

    Description: Gets the Year.
  */
    public int getYear() {
        return this.year;
    }
    
    /**
    Method: setCost
    Inputs: int Cost
    Returns: void

    Description: Sets the Cost.
  */
    public void setCost(int Cost) {
        this.cost = Cost;
    }

    /**
    Method: getCost
    Inputs: void
    Returns: int

    Description: Gets the Cost.
  */
    public int getCost() {
        return this.cost;
    }
    
    /**
    Method: setNumFloors
    Inputs: int Num_floors
    Returns: void

    Description: Sets the Number of floors.
  */
    public void setNumFloors(int Num_floors) {
        this.num_floors = Num_floors;
    }

    /**
    Method: getNumFloors
    Inputs: void
    Returns: int

    Description: Gets the Number of floors.
  */
    public int getNumFloors() {
        return this.num_floors;
    }
    
    /**
    Method: setNumBed
    Inputs: int Num_bed
    Returns: void

    Description: Sets the number of beds.
  */
    public void setNumBed(int Num_bed) {
        this.num_bed = Num_bed;
    }

    /**
    Method: getNumBed
    Inputs: void
    Returns: int

    Description: Gets the number of beds.
  */
    public int getNumBed() {
        return this.num_bed;
    }
    
    /**
    Method: setNumBath
    Inputs: int Num_bath
    Returns: void

    Description: Sets the number of baths.
  */
    public void setNumBath(int Num_bath) {
        this.num_bath = Num_bath;
    }

    /**
    Method: getNumBath
    Inputs: void
    Returns: int

    Description: Gets the number of baths.
  */
    public int getNumBath() {
        return this.num_bath;
    }
    
    /**
    Method: setSqrFeet
    Inputs: int Sqr_feet
    Returns: void

    Description: Sets the Square feet.
  */
    public void setSqrFeet(int Sqr_feet) {
        this.sqr_feet = Sqr_feet;
    }

    /**
    Method: getSqrFeet
    Inputs: void
    Returns: int 

    Description: Gets the Square Feet
  */
    public int getSqrFeet() {
        return this.sqr_feet;
    }
    
    /**
    Method: setDaysListed
    Inputs: int Days_listed
    Returns: void

    Description: Sets the days listed.
  */
    public void setDaysListed(int Days_listed) {
        this.days_listed = Days_listed;
    }

    /**
    Method: getDaysListed
    Inputs: void
    Returns: int

    Description: Gets the days listed.
  */
    public int getDaysListed() {
        return this.days_listed;
    }
}
