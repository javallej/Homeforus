/*
  File: ConsumerListObject.java 
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Getter/Setter for Consumer List.
*/

package main.java.homeforus.core;

/**
Class: ConsumerListObject

Description: Getter/Setter for Consumer List.
*/
public class ConsumerListObject {
    
    
    private int consumerid;
    private String consumer_username;
    private String dob;
    private int ssn;
    
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
    Method: setDOB
    Inputs: String Dob
    Returns: void

    Description: Sets DOB.
  */
    public void setDOB(String Dob) {
        this.dob = Dob;
    }

    /**
    Method: getDOB
    Inputs: void
    Returns: String

    Description: Gets DOB.
  */
    public String getDOB() {
        return this.dob;
    }
    
    /**
    Method: setSSN
    Inputs: int Ssn
    Returns: void

    Description: Sets the SSN.
  */
    public void setSSN(int Ssn) {
        this.ssn = Ssn;
    }

    /**
    Method: getSSN
    Inputs: void
    Returns: int

    Description: Gets the SSN.
  */
    public int getSSN() {
        return this.ssn;
    }
}

