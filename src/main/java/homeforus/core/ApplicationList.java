package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationList {
    
    public List<ApplicationListObject> List(int House_ID, int Consumer_ID, int Realtor_ID) throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <ApplicationListObject> applicationinformation = new ArrayList<ApplicationListObject>();

        try {


            String query = "SELECT * FROM APPLICATION WHERE APPLICATION.House_ID = ? AND APPLICATION.Consumer_ID = ? AND APPLICATION Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_ID);
            stmt.setInt(2, Consumer_ID);
            stmt.setInt(3, Realtor_ID);

            rs = stmt.executeQuery();

            
            while (rs.next()) {
                ApplicationListObject aobject = new ApplicationListObject();
                aobject.setHouseID(rs.getInt(1));
                aobject.setConsumerID(rs.getInt(2));
                aobject.setRealtorID(rs.getInt(3));
                applicationinformation.add(aobject);
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
        return applicationinformation;
    }

}
