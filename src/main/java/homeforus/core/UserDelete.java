package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDelete {
    
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
