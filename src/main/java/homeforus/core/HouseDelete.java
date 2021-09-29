/*
  File: HouseDelete.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Deletes a house from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: HouseDelete   

Description:  Deletes a house from the database.
*/

public class HouseDelete {

    /**
    Method: delete
    Inputs: int House_ID
    Returns: void

    Description: Deletes a house from the database.
  */

    public void delete(int House_ID) throws IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "DELETE FROM HOUSE WHERE HOUSE.House_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
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
