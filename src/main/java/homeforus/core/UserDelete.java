/*
  File: UserDelete.java
  Author: Group 9 SER322
  Date: 09/26/2021
  
  Description: Deletes user from MySQL.
*/


package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: UserDelete

Description: Class to delete user(s) from MySQL.
*/

public class UserDelete {
    
    /**
    Method: Deleteuser
    Inputs: Connection connect, int UserID
    Returns: void

    Description: Deletes user based off UserID.
  */
    public void Deleteuser(Connection connect, int UserID) {
        
            ResultSet rs = null;
            PreparedStatement stmt = null;

            try {

                connect.setAutoCommit(false);
                
                String query = "DELETE FROM USER WHERE USER.User_ID = ?";

                stmt = connect.prepareStatement(query);
                stmt.setInt(1, UserID);
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
