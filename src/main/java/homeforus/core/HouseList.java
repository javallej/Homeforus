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

import main.java.homeforus.gui.SearchInput;

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

    public List<HouseListObject> ListAllSearchInput(SearchInput searchin) throws SQLException, IOException {
        
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

    public List<HouseListObject> ListPriceMax(int Cost) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Cost <= ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Cost);
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
    
    public List<HouseListObject> ListPriceMin(int Cost) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Cost >= ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Cost);
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
    
    public List<HouseListObject> ListRealtorID(int Realtor_ID) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Realtor_ID = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Realtor_ID);
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
    
    public List<HouseListObject> ListRealtorUsername(String Realtor_Username) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Realtor_Username = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Realtor_Username);
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
    
    public List<HouseListObject> ListState(String State) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.State = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, State);
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
    
    public List<HouseListObject> ListCity(String City) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.City = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, City);
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
    
    public List<HouseListObject> ListZip(String Zip) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Zip = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Zip);
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
    
    public List<HouseListObject> ListStreet(String Street) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Street = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Street);
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
    
    public List<HouseListObject> ListHouseNumber(int House_Number) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.House_Number = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, House_Number);
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
    
    public List<HouseListObject> ListCost(int Cost) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Cost = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Cost);
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
    
    public List<HouseListObject> ListYear(int Year) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Year = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Year);
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
    
    public List<HouseListObject> ListNumFloors(int Num_Floors) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Num_Floors = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Num_Floors);
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
    
    public List<HouseListObject> ListNumBed(int Num_Bed) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Num_Bed = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Num_Bed);
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
    
    public List<HouseListObject> ListNumBath(int Num_Bath) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Num_Bath = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Num_Bath);
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
    
    public List<HouseListObject> ListSqrFeet(int Sqr_Feet) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Sqr_Feet = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Sqr_Feet);
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
    
    public List<HouseListObject> ListDaysListed(int Days_Listed) throws SQLException, IOException{
        
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        Connection connect = DBConnect.connect(Setup.setup().get("jdbcUrl"),Setup.setup().get("jdbcUser"), Setup.setup().get("jdbcPasswd"),
                Setup.setup().get("jdbcDriver"));
        
        List <HouseListObject> houseinformation = new ArrayList<HouseListObject>();

        try {


            String query = "SELECT * FROM HOUSE WHERE HOUSE.Days_Listed = ?";

            stmt = connect.prepareStatement(query);
            stmt.setInt(1, Days_Listed);
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

