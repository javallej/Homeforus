package main.java.homeforus.core;

public class ConsumerListObject {
    
    private int consumerid;
    private String consumer_username;
    private String dob;
    private int ssn;
    
    public void setConsumerID(int Consumerid) {
        this.consumerid = Consumerid;
    }

    public int getConsumerID() {
        return this.consumerid;
    }
    
    public void setConsumerUsername(String Consumer_username) {
        this.consumer_username = Consumer_username;
    }

    public String getConsumerUsername() {
        return this.consumer_username;
    }
    
    public void setDOB(String Dob) {
        this.dob = Dob;
    }

    public String getDOB() {
        return this.dob;
    }
    
    public void setSSN(int Ssn) {
        this.ssn = Ssn;
    }

    public int getSSN() {
        return this.ssn;
    }
}

