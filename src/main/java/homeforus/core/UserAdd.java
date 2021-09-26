/*
  File: UserAdd.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Adds a user to the database.
*/

package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
Class: UserAdd

Description: Adds a user to the database.
*/

public class UserAdd {
    
    /**
    Method: add
    Inputs: Connection connect, String Username, String FirstName, String LastName, String Phone, String Email, String Password
    Returns: void

    Description: Adds a user to the database.
  */
    public void add(Connection connect, String Username, String FirstName, String LastName, String Phone, String Email, String Password)
    {
        ResultSet rs = null;
        Statement stmt = null;
        
        try {

            connect.setAutoCommit(false);
            
            
            String query = "INSERT INTO USER (User_Username,First_Name,Last_Name,Phone,Email,Password) VALUES" + "('" + Username + "','" + FirstName + "','" + LastName + "','" + Phone 
                    + "','" + Email + "','" + Password + "');";
            
            stmt = connect.prepareStatement(query);
            System.out.println(query);

            if (stmt.executeUpdate(query) > 0) {
                System.out.println("SUCCESS!" + "\n");
            }
            
            connect.commit();
                   
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
}}
