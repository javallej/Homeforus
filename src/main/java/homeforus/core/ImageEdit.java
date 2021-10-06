/*
  File: ImageEdit.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Edits a image from the database.
*/

package main.java.homeforus.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

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

    public void editImageGUI(int houseID, File image) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "UPDATE IMAGE SET File_Path = ?, Image_Name = ? WHERE IMAGE.House_ID = ?";

            Path path = Paths.get(image.getPath());
            String directory = path.getParent().toString();
            String[] dirArr = directory.split("\\\\", Pattern.LITERAL);
            String pathString = dirArr[dirArr.length - 1] + "/";
            System.out.println(pathString);

            stmt = connect.prepareStatement(query);
            stmt.setString(1, pathString);
            stmt.setString(2, image.getName());
            stmt.setInt(3, houseID);
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

    public synchronized InputStream getImage(String Image_Name, int House_ID) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        InputStream b_stream = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            
            String query = "SELECT * FROM IMAGE WHERE Image_Name = ? AND House_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Image_Name);
            stmt.setInt(2, House_ID);
            rs = stmt.executeQuery();

            if(rs.next()) {
                Blob blob = rs.getBlob("Image_Data");
                b_stream = blob.getBinaryStream(); 
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
        return b_stream;
    }
    
}
