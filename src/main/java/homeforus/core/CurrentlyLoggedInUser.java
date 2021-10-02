package main.java.homeforus.core;

public class CurrentlyLoggedInUser {


    private String username;
    private int userID;
    private boolean isRealtor;

    public CurrentlyLoggedInUser(String username, int userID, boolean isRealtor) {
        this.username = username;
        this.userID = userID;
        this.isRealtor = isRealtor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isRealtor() {
        return isRealtor;
    }

    public void setRealtor(boolean realtor) {
        isRealtor = realtor;
    }

}
