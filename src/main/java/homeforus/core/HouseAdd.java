/*
  File: HouseAdd.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Adds a house to the database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: HouseAdd    

Description: Adds a house to the database.
*/
public class HouseAdd {

    /**
    Method: add
    Inputs: int Realtor_ID, String Realtor_Username, String State, String City, String Zip, String Street, int 
            House_Number, int Cost, int Year, int Num_Floors, int Num_Bed, int Num_Bath, int Sqr_feet, int Days_Listed
    Returns: void

    Description: Adds a house to the database.
  */
    
    public void add(int Realtor_ID, String Realtor_Username, String State, String City, String Zip, String Street, int 
            House_Number, int Cost, int Year, int Num_Floors, int Num_Bed, int Num_Bath, int Sqr_feet, int Days_Listed
            ) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "INSERT INTO HOUSE (Realtor_ID, Realtor_Username, State, City, Zip, Street, "
                    + "House_Number, Cost, "
                    + "Year, Num_Floors, Num_Bed, Num_Bath, Sqr_Feet, Days_Listed)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,0)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
            stmt.setString(2, Realtor_Username);
            stmt.setString(3, State);
            stmt.setString(4, City);
            stmt.setString(5, Zip);
            stmt.setString(6, Street);
            stmt.setInt(7, House_Number);
            stmt.setInt(8, Cost);
            stmt.setInt(9, Year);
            stmt.setInt(10, Num_Floors);
            stmt.setInt(11, Num_Bed);
            stmt.setInt(12, Num_Bath);
            stmt.setInt(13, Sqr_feet);
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
