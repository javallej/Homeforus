/*
  File: HouseList.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: Lists a house from the database.
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
Class: HouseList   

Description: Lists a house from the database.
*/

public class HouseList {
    
    /**
    Method: List
    Inputs: int House_ID
    Returns: List<HouseListObject>

    Description: Lists a house from the database.
  */

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
                hobject.setHouseID(rs.getInt(1));
                hobject.setRealtorID(rs.getInt(2));
                hobject.setRealtorUsername(rs.getString(3));
                hobject.setState(rs.getString(4));
                hobject.setCity(rs.getString(5));
                hobject.setZip(rs.getString(5));
                hobject.setStreet(rs.getString(7));
                hobject.setCost(rs.getInt(8));
                hobject.setYear(rs.getInt(9));
                hobject.setNumFloors(rs.getInt(10));
                hobject.setNumBed(rs.getInt(11));
                hobject.setNumBath(rs.getInt(12));
                hobject.setSqrFeet(rs.getInt(13));
                hobject.setDaysListed(rs.getInt(14));
                houseinformation.add(hobject);
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
