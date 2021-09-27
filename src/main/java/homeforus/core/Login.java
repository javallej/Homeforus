package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Login {
    
    public HashMap<String, String> logincheck(String username) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        HashMap<String, String> logininfo = new HashMap<String, String>();
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {
            
            String query = "SELECT u.User_Username, u.Password FROM USER AS u WHERE u.User_Username = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                logininfo.put("username", rs.getString(1));
                logininfo.put("password", rs.getString(2));
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

        return logininfo;
    }

}
