package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseEdit {
    
    public void editAll(String State, String Zip, String Street, int House_Number, int Cost, int Year, int Num_Floors, int Num_Bed,
            int Num_Bath, int Sqr_Feet, int Days_Listed) throws IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        try {

            connect.setAutoCommit(false);
            
            String query = "UPDATE HOUSE SET State,Zip,Street,House_Number,Cost,Year,Num_Floors,Num_Bed,Num_Bath,Sqr_Feet,"
                    + "Days_Listed = ?,?,?,?,?,?,?,?,?,?,? WHERE HOUSE.House_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, State);
            stmt.setString(2, Zip);
            stmt.setString(3, Street);
            stmt.setInt(4, House_Number);
            stmt.setInt(5, Cost);
            stmt.setInt(6, Year);
            stmt.setInt(7, Num_Floors);
            stmt.setInt(8, Num_Bed);
            stmt.setInt(9, Num_Bath);
            stmt.setInt(10, Sqr_Feet);
            stmt.setInt(11, Days_Listed);
            
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
