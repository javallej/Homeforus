/*
  File: ImageEdit.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Edits a image from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: ImageEdit   

Description: Edits a image from the database.
*/

public class ImageEdit {
    
    /**
    Method: editImage
    Inputs: String File_Path, String Image_Name
    Returns: void

    Description: Edits a image from the database.
  */

    
    public void editImage(String File_Path, String Image_Name) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            String query = "UPDATE IMAGE SET File_Path = ? WHERE Image_Name = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, File_Path);
            stmt.setString(2, Image_Name);
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
