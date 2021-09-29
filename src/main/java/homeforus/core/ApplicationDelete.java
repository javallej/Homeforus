/*
  File: ApplicationDelete.java
  Author: SER322 Group 9
  Date:  09/28/2021
  
  Description: Deletes the application from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: ApplicationDelete   

Description: Deletes the application from the database.
*/
public class ApplicationDelete {

    /**
    Method: delete
    Inputs: int House_ID, int Consumer_ID, int Realtor_ID
    Returns: void

    Description: Deletes the application from the database.
  */
    public void delete(int House_ID, int Consumer_ID, int Realtor_ID) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "DELETE FROM APPLICATION WHERE APPLICATION.HOUSE_ID = ? AND "
                    + "APPLICATION.Consumer_ID = ? AND APPLICATION.Realtor_ID = ? ";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setInt(2, Consumer_ID);
            stmt.setInt(3, Realtor_ID);
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
