/*
  File: RealtorDelete.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Deletes a realtor from the database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: RealtorDelete    

Description: Deletes a realtor from the database.
*/
public class RealtorDelete {
    
    /**
    Method: delete
    Inputs: int Realtor_ID
    Returns: void

    Description: Deletes a realtor from the database.
  */
    public void delete(int Realtor_ID) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "DELETE FROM REALTOR WHERE REALTOR.Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
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
