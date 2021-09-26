package main.java.homeforus.core;


public class UserListObject {

    private int userid;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    
    public void setUserID(int Userid) {
        this.userid = Userid;
    }
    
    public int getUserID() {
        return this.userid;
    }
    
    public void setUserUsername (String userName) {
        this.username = userName;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    
    public String getFirstName() {
        return this.firstname;
    }
    
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    
    public String getLastName() {
        return this.lastname;
    }
    
    public void setPhone(String Phone) {
        this.phone = Phone;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPassword(String Password) {
        this.password = Password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    public String getEmail() {
        return this.email;
    }

}
