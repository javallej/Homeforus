/*
  File: RealtorList.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Lists realtor from the database.
*/


package main.java.homeforus.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
Class: RealtorList    

Description: List the realtor from the database.
*/

public class RealtorList {

    /**
    Method: List
    Inputs: int Realtor_ID
    Returns: List<RealtorListObject>

    Description: List the realtor from the database.
  */

    public List<RealtorListObject> List(int Realtor_ID) throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <RealtorListObject> realtorinformation = new ArrayList<RealtorListObject>();

        try {


            String query = "SELECT * FROM REALTOR WHERE REALTOR.Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                RealtorListObject robject = new RealtorListObject();
                robject.setRealtorID(rs.getInt(1));
                robject.setRealtorUsername(rs.getString(2));
                robject.setRealtorBusinessName(rs.getString(3));
                realtorinformation.add(robject);
            }
            
            return realtorinformation;
            
            
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
        return realtorinformation;
    }

}
