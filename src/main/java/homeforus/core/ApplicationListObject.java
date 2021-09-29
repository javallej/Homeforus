/*
  File: ApplicationListObject.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Getter/Setter to list Applications.
*/


package main.java.homeforus.core;

/**
Class: ApplicationListObject   

Description: Getter/Setter to list Applications.
*/

public class ApplicationListObject {

    private int house_id;
    private int consumerid;
    private String consumer_username;
    private int realtor_id;
    private String realtor_username;
    private String status;
    
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
    Method: setConsumerID
    Inputs: int Consumerid
    Returns: Sets the Consumer_ID.

    Description:
  */
    public void setConsumerID(int Consumerid) {
        this.consumerid = Consumerid;
    }

    /**
    Method: getConsumerID()
    Inputs: void
    Returns: int

    Description: Gets the Consumer_ID.
  */
    public int getConsumerID() {
        return this.consumerid;
    }
    
    /**
    Method: setConsumerUsername
    Inputs: String Consumer_username
    Returns: void

    Description: Sets the Consumer Username.
  */
    public void setConsumerUsername(String Consumer_username) {
        this.consumer_username = Consumer_username;
    }

    /**
    Method: getConsumerUsername
    Inputs: void
    Returns: String

    Description: Get the Consumer Username.
  */
    public String getConsumerUsername() {
        return this.consumer_username;
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
    Method: setStatus
    Inputs: String Status
    Returns: void

    Description: Sets the Status.
  */

    public void setStatus(String Status) {
        this.status = Status;
    }

    /**
    Method: getStatus
    Inputs: void
    Returns: String

    Description: Gets the Status.
  */

    public String getStatus() {
        return this.status;
    }

}
