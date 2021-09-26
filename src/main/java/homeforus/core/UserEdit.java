/*
  File: UserEdit.java
  Author:   SER322 Group 9
  Date: 09/26/2021
  
  Description: Edit user information from database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: UserEdit 

Description: Edit user information from the database.
*/

public class UserEdit {
    
    
    /**
    Method: editUsername
    Inputs: Connection connect, int UserID, String NewUsername
    Returns: void

    Description: Changes username.
     * @throws IOException 
  */

    public void editUsername(int UserID, String NewUsername) throws IOException {
        
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                    Setup.setup().get("jdbcDriver"));

            try {

                connect.setAutoCommit(false);
                
                String query = "UPDATE USER SET User_Username = ? WHERE User_ID = ?";

                stmt = connect.prepareStatement(query);
                stmt.setString(1, NewUsername);
                stmt.setInt(2, UserID);
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
