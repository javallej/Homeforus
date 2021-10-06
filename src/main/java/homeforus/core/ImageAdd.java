/*
  File: ImageAdd.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Adds an image to the database.
*/


package main.java.homeforus.core;

import java.io.File;
import java.io.FileInputStream;

/**
Class: ImageAdd

Description: Adds an image to the database.
*/

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Method: add
Inputs: int House_ID, String File_Path, String Image_Name
Returns: void

Description: Adds an image to the database.
*/
public class ImageAdd {
    
    public void add(int House_ID, String File_Path, String Image_Name) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "INSERT INTO IMAGE VALUES (?,?,?)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setString(2, File_Path);
            stmt.setString(3, Image_Name);
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

    public void addimage(int House_ID, String File_Path, String Image_Name) throws IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            File image = new File(File_Path + Image_Name);
            FileInputStream inputstream = new FileInputStream(image);
            
            String query = "INSERT INTO IMAGE VALUES (?,?,?,?)";
           
            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setString(2, File_Path);
            stmt.setString(3, Image_Name);
            stmt.setBinaryStream(4,inputstream, (int)(image.length()));
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

    public void addImgGUI(int House_ID, File image) throws IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            Path path = Paths.get(image.getPath());
            String directory = path.getParent().toString() + "\\";
            FileInputStream inputstream = new FileInputStream(image);

            String query = "INSERT INTO IMAGE VALUES (?,?,?,?)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setString(2, directory);
            stmt.setString(3, image.getName());
            stmt.setBinaryStream(4,inputstream, (int)(image.length()));
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
