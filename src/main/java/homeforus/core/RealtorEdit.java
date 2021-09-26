/*
  File: RealtorEdit.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Edit a realtor from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: RealtorEdit   

Description: Edit a realtor from the database.
*/

public class RealtorEdit {

    /**
    Method: editBusiness_Name
    Inputs: String Business_Name, int Realtor_ID
    Returns: void

    Description: Edit a realtor business name.
  */
    public void editBusiness_Name(String Business_Name, int Realtor_ID) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            String query = "UPDATE REALTOR SET Business_Name = ? WHERE Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Business_Name);
            stmt.setInt(2, Realtor_ID);
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
