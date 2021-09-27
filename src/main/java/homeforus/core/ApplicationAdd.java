package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationAdd {
    
    public void add(int House_ID, int Consumer_ID, String Consumer_Username, int Realtor_ID, String Realtor_Username, String Status
            ) throws IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"), Setup.setup().get("jdbcUser"),
                Setup.setup().get("jdbcPasswd"), Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);

            String query = "INSERT INTO APPLICATION VALUES (?,?,?,?,?,?)";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setInt(2, Consumer_ID);
            stmt.setString(3, Consumer_Username);
            stmt.setInt(4, Realtor_ID);
            stmt.setString(5, Realtor_Username);
            stmt.setString(6, Status);
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
