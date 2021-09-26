/*
  File: ConsumerAdd.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Adds a consumer to the database.
*/

package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
Class: ConsumerAdd

Description: Adds a consumer to the database.
*/

public class ConsumerAdd {

    /**
    Method: add
    Inputs: Connection connect, int Consumer_ID, String Consumer_Username, String DOB, int SSN
    Returns: void

    Description: Adds a consumer to the database.
  */

    public void add(Connection connect, int Consumer_ID, String Consumer_Username, String DOB, int SSN) {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {

            connect.setAutoCommit(false);
            
            String query = "INSERT INTO CONSUMER VALUES (?,?,?,?)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Consumer_ID);
            stmt.setString(2, Consumer_Username);
            stmt.setString(3, DOB);
            stmt.setInt(4, SSN);
            System.out.println(query);
            stmt.executeUpdate();
            
            connect.commit();

        } catch (Exception exc) {
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
}
}
