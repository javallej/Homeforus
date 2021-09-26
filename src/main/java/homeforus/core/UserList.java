package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserList {

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
