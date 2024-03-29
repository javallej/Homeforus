package main.java.homeforus.gui;

public class ApplicationInfo {

    private String firstName;
    private String lastName;
    private String status;
    private int daysOld;
    private String address;
    private String image;
    private int houseID;

    public ApplicationInfo(String firstName, String lastName, String status,  String address, String image, int houseID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.daysOld = daysOld;
        this.address = address;
        this.image = image;
        this.houseID = houseID;
    }

    public String getImage() {
        return image;
    }

    public int getHouseID() {
        return houseID;
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

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", daysOld=" + daysOld +
                ", address='" + address + '\'' +
                '}';
    }
}
