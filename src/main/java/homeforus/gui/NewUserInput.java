package main.java.homeforus.gui;

public class NewUserInput {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private boolean isRealtor;
    private String businessName;
    private String DOB;
    private int SSN;

    @Override
    public String toString() {
        return "NewUserInput{" +
                "username='" + getUsername() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", isRealtor=" + isRealtor() +
                ", businessName='" + getBusinessName() + '\'' +
                ", DOB='" + getDOB() + '\'' +
                ", SSN=" + getSSN() +
                '}';
    }

    public NewUserInput(String username, String firstName, String lastName, String password,
                        String email, String phone, boolean isRealtor, String businessName, String DOB, int SSN) {
        this.setUsername(username);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setRealtor(isRealtor);
        this.setBusinessName(businessName);
        this.setDOB(DOB);
        this.setSSN(SSN);
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
