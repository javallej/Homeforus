/*
  File: RealtorListObject.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Getter/Setter for Realtor List.
*/

package main.java.homeforus.core;

/**
Class:  RealtorListObject  

Description: Getter/Setter for Realtor List.
*/

public class RealtorListObject {

    private int realtor_id;
    private String realtor_username;
    private String business_name;
    
    /**
    Method: setRealtorID
    Inputs: int Realtor_id
    Returns: void

    Description: Sets the Realtor ID.
  */
    public void setRealtorID(int Realtor_id) {
        this.realtor_id = Realtor_id;
    }

    /**
    Method: getRealtorID
    Inputs: void
    Returns: int

    Description: Gets the Realtor ID.
  */
    public int getRealtorID() {
        return this.realtor_id;
    }
    
    /**
    Method: setRealtorUsername
    Inputs: String Realtor_username
    Returns: void

    Description: Sets the Realtor Username.
  */
    public void setRealtorUsername(String Realtor_username) {
        this.realtor_username = Realtor_username;
    }
    
    /**
    Method: getRealtorUsername
    Inputs: void
    Returns: String

    Description: Gets the Realtor Username.
  */
    public String getRealtorUsername() {
        return this.realtor_username;
    }
    
    /**
    Method: setRealtorBusinessName
    Inputs: String Business_Name
    Returns: void

    Description: Sets the Realtor Business Name.
  */
    public void setRealtorBusinessName(String Business_Name) {
        this.business_name = Business_Name;
    }

    /**
    Method: void
    Inputs: String Business_Name
    Returns: String

    Description: Gets the Realtor Business Name.
  */
    public String getRealtorBusinessName() {
        return this.business_name;
    }
}
