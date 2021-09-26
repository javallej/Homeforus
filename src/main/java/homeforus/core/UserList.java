/*
  File: UserList.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Gets user information from database.
*/


package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
Class: UserList  

Description: Gets user information from database.
*/

public class UserList {

    /**
    Method: Listusername
    Inputs: Connection connect, String Username
    Returns: List<UserListObject>

    Description: Gets user information and returns as a list of object.
  */
    public List<UserListObject> Listusername(Connection connect, String Username) throws SQLException {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List <UserListObject> userinformation = new ArrayList<UserListObject>();

        try {


            String query = "SELECT * FROM USER WHERE USER.User_Username = ?";

            stmt = connect.prepareStatement(query);
            stmt.setString(1, Username);
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                UserListObject uobject = new UserListObject();
                uobject.setUserID(rs.getInt(1));
                uobject.setUserUsername(rs.getString(2));
                uobject.setFirstName(rs.getString(3));
                uobject.setLastName(rs.getString(4));
                uobject.setPhone(rs.getString(4));
                uobject.setEmail(rs.getString(5));
                uobject.setPassword(rs.getString(5));
                userinformation.add(uobject);
            }
            
            return userinformation;
            
            
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
        return userinformation;
    }

    

}
