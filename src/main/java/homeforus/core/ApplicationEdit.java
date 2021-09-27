package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationEdit {
    
    public void editStatus(String Status, int House_ID, int Consumer_ID, int Realtor_ID) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            String query = "UPDATE APPLICATION SET Status = ? WHERE House_ID = ? AND Consumer_ID = ? AND Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Status);
            stmt.setInt(2, House_ID);
            stmt.setInt(2, Consumer_ID);
            stmt.setInt(2, Realtor_ID);
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
