/*
  File: RealtorAdd.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Adds a realtor to the database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: RealtorAdd

Description: Adds a realtor to the database.
*/
public class RealtorAdd {
    
    /**
    Method: add
    Inputs: int Realtor_ID, String Realtor_Username, String Business_Name
    Returns: void

    Description: Adds a realtor to the database.
  */

    public void add(int Realtor_ID, String Realtor_Username, String Business_Name) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "INSERT INTO REALTOR VALUES (?,?,?)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
            stmt.setString(2, Realtor_Username);
            stmt.setString(3, Business_Name);
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