package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserEdit {
    
    public void editUsername(Connection connect, int UserID, String NewUsername) {
        
            ResultSet rs = null;
            PreparedStatement stmt = null;

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
