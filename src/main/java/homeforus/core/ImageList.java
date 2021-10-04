/*
  File: ImageList.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Lists an image from the database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
Class: ImageList  

Description: Lists an image from the database.
*/

public class ImageList {

    /**
    Method: List
    Inputs: int House_ID
    Returns: List<ImageListObject>

    Description: Lists an image from the database.
  */
    
    public List<ImageListObject> List(int House_ID) throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <ImageListObject> imageinformation = new ArrayList<ImageListObject>();

        try {
            String query = "SELECT * FROM IMAGE WHERE Image.House_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);

            rs = stmt.executeQuery();

            
            while (rs.next()) {
                ImageListObject iobject = new ImageListObject();
                iobject.setHouseID(rs.getInt(1));
                iobject.setFilePath(rs.getString(2));
                iobject.setImageName(rs.getString(3));
                imageinformation.add(iobject);
            }

            
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
        return imageinformation;
    }
}
