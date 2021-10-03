package main.java.homeforus.gui;

public class ApplicationInfo {

    private String firstName;
    private String lastName;
    private String status;
    private int daysOld;
    private String address;

    public ApplicationInfo(String firstName, String lastName, String status, int daysOld, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.daysOld = daysOld;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDaysOld() {
        return daysOld;
    }

    public void setDaysOld(int daysOld) {
        this.daysOld = daysOld;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
