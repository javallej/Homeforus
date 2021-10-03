/*
  File: ApplicationList.java
  Author: SER322 Group 9
  Date: 09/28/2021
  
  Description: List Application from the database.
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
Class: ApplicationList

Description: List Application from the database.
*/

public class ApplicationList {
    
    /**
    Method: List
    Inputs: int House_ID, int Consumer_ID, int Realtor_ID
    Returns: List<ApplicationListObject> 

    Description: List Application from the database using House_ID, Consumer_ID, Realtor_ID
  */
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

    /**
    Method: ListAll
    Inputs: void
    Returns: List<ApplicationListObject>

    Description: Returns all Applications from the database.
  */
    public List<ApplicationListObject> ListAll() throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <ApplicationListObject> applicationinformation = new ArrayList<ApplicationListObject>();

        try {


            String query = "SELECT * FROM APPLICATION WHERE APPLICATION.Consumer_ID = ?";

            stmt = connect.prepareStatement(query);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                ApplicationListObject aobject = new ApplicationListObject();
                aobject.setHouseID(rs.getInt(1));
                aobject.setConsumerID(rs.getInt(2));
                aobject.setConsumerUsername(rs.getString(3));
                aobject.setRealtorID(rs.getInt(4));
                aobject.setRealtorUsername(rs.getString(5));
                aobject.setStatus(rs.getString(6));
                
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


    /**
    Method: ListUserID
    Inputs: void


    /**
     Method: ListByConsumerID
     Inputs: void
     Returns: List<ApplicationListObject>

     Description: Returns all Applications from the database.
     */
    public List<ApplicationListObject> ListByRealtorID(int Realtor_ID) throws SQLException, IOException {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));

        List <ApplicationListObject> applicationinformation = new ArrayList<ApplicationListObject>();

        try {


            String query = "SELECT * FROM APPLICATION a, REALTOR r WHERE  a.Realtor_ID  = r.Realtor_ID AND a.realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
            rs = stmt.executeQuery();


            while (rs.next()) {
                ApplicationListObject aobject = new ApplicationListObject();
                aobject.setHouseID(rs.getInt(1));
                aobject.setConsumerID(rs.getInt(2));
                aobject.setConsumerUsername(rs.getString(3));
                aobject.setRealtorID(rs.getInt(4));
                aobject.setRealtorUsername(rs.getString(5));
                aobject.setStatus(rs.getString(6));

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

    /**
     Method: ListByConsumerID
     Inputs: void
>>>>>>> testing
    Returns: List<ApplicationListObject>

    Description: Returns all Applications from the database.
  */

    public List<ApplicationListObject> ListByConsumerID(int Consumer_ID) throws SQLException, IOException {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <ApplicationListObject> applicationinformation = new ArrayList<ApplicationListObject>();

        try {


            String query = "SELECT * FROM APPLICATION a JOIN CONSUMER c ON a.Consumer_ID  = c.Consumer_ID WHERE a.Consumer_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Consumer_ID);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                ApplicationListObject aobject = new ApplicationListObject();
                aobject.setHouseID(rs.getInt(1));
                aobject.setConsumerID(rs.getInt(2));
                aobject.setConsumerUsername(rs.getString(3));
                aobject.setRealtorID(rs.getInt(4));
                aobject.setRealtorUsername(rs.getString(5));
                aobject.setStatus(rs.getString(6));
                
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
