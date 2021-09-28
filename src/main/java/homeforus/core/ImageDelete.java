/*
  File: ImageDelete.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Deletes an image from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: ImageDelete    

Description: Deletes an image from the database.
*/


public class ImageDelete {

    /**
    Method: delete
    Inputs: int House_ID, String File_Path
    Returns: void

    Description: Deletes an image from the database.
  */

    public void delete(int House_ID, String File_Path) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "DELETE FROM IMAGE WHERE IMAGE.HOUSE_ID = ? AND "
                    + "IMAGE.File_Path = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setString(2, File_Path);
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
