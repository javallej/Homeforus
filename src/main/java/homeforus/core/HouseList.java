package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseList {
    
    public List<HouseListObject> List(int House_ID) throws SQLException, IOException {
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.House_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                HouseListObject hobject = new HouseListObject();
                hobject.setRealtorID(rs.getInt(1));
                hobject.setRealtorUsername(rs.getString(2));
                hobject.setRealtorBusinessName(rs.getString(3));
                houseinformation.add(robject);
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
        return houseinformation;
    }

}
