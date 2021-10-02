package main.java.homeforus.gui;

public class NewUserInput {

    String username;
    String firstName;
    String lastName;
    String password;
    String email;
    String phone;
    boolean isRealtor;
    String businessName;
    String DOB;
    int SSN;

    @Override
    public String toString() {
        return "NewUserInput{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isRealtor=" + isRealtor +
                ", businessName='" + businessName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", SSN=" + SSN +
                '}';
    }
    
    public NewUserInput() {
        
    }

    public NewUserInput(String username, String firstName, String lastName, String password,
                        String email, String phone, boolean isRealtor, String businessName, String DOB, int SSN) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isRealtor = isRealtor;
        this.businessName = businessName;
        this.DOB = DOB;
        this.SSN = SSN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isRealtor() {
        return isRealtor;
    }

    public void setRealtor(boolean realtor) {
        isRealtor = realtor;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
}
