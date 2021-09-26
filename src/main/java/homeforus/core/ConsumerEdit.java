/*
  File: ConsumerEdit.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Edits a consumer from the database.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
Class: ConsumerEdit    

Description: Edits a consumer from the database.
*/
public class ConsumerEdit {
    
    /**
    Method: editDOB
    Inputs: String DOB, int Consumer_ID
    Returns: void

    Description: Edits a Consumers DOB.
  */
    public void editDOB(String DOB, int Consumer_ID) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            String query = "UPDATE CONSUMER SET DOB = ? WHERE Consumer_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, DOB);
            stmt.setInt(2, Consumer_ID);
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
