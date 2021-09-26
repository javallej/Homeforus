/*
  File: UserListObject.java
  Author: Group 9 SER322
  Date: 09/26/2021
  
  Description: Getter/Setter for User List.
*/

package main.java.homeforus.core;

/**
Class: UserListObject  

Description: Getter/Setter for User List.
*/

public class UserListObject {

    private int userid;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    
    /**
    Method: setUserID
    Inputs: int Userid
    Returns: void

    Description: Sets the UserID.
  */
    public void setUserID(int Userid) {
        this.userid = Userid;
    }
    
    /**
    Method: getUserID
    Inputs: void
    Returns: int

    Description: Gets the UserID.
  */
    public int getUserID() {
        return this.userid;
    }
    
    /**
    Method: setUsername
    Inputs: String userName
    Returns: void

    Description: Sets the Username.
  */
    public void setUserUsername (String userName) {
        this.username = userName;
    }
    
    /**
    Method: getUsername
    Inputs: void
    Returns: String

    Description: Gets the Username.
  */
    public String getUsername() {
        return this.username;
    }
    
    /**
    Method: setFirstName
    Inputs: String fristName
    Returns: void

    Description: Sets the firstname.
  */
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    
    /**
    Method: getFirstName
    Inputs: void
    Returns: String

    Description: Gets the first name.
  */
    public String getFirstName() {
        return this.firstname;
    }
    
    /**
    Method: setLastName
    Inputs: String lastName
    Returns: void

    Description: Sets the last name.
  */
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    
    /**
    Method: getLastName
    Inputs: void
    Returns: String

    Description: Gets the last name.
  */
    public String getLastName() {
        return this.lastname;
    }
    
    /**
    Method: setPhone
    Inputs: String Phone
    Returns: void

    Description: Sets the phone number.
  */
    public void setPhone(String Phone) {
        this.phone = Phone;
    }
    
    /**
    Method: getPhone
    Inputs: void
    Returns: String

    Description: Gets the phone number.
  */
    public String getPhone() {
        return this.phone;
    }
    
    /**
    Method: setPassword
    Inputs: String Password
    Returns: void

    Description: Sets the password.
  */
    public void setPassword(String Password) {
        this.password = Password;
    }
    
    /**
    Method: getPassword
    Inputs: void
    Returns: String

    Description: Gets the password.
  */
    public String getPassword() {
        return this.password;
    }
    
    /**
    Method: setEmail
    Inputs: String Email
    Returns: void

    Description: Sets the email.
  */
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    /**
    Method: getEmail
    Inputs: void
    Returns: String

    Description: Gets the email.
  */
    public String getEmail() {
        return this.email;
    }

}
