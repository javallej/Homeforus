/*
  File: Main.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Main program for homeforus.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
Class: Main

Description: Start of program.
*/

public class Main {

    /**
    Method: main
    Inputs: String[] args
    Returns: void

    Description: Start of program.
  */

    public static void main(String[] args) {

        try (InputStream input = RDBMconnect.class.getClassLoader().getResourceAsStream("rdbm.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Unable to find rdbm.properties file!");
                return;
            }

            prop.load(input);

            //DBConnect session = new DBConnect();
            
            String driver = prop.getProperty("jdbcDriver");
            String url = prop.getProperty("jdbcUrl");
            String user = prop.getProperty("jdbcUser");
            String password = prop.getProperty("jdbcPasswd");
            String database = "testhomeforus";
       
            UserAdd useraddData = new UserAdd();
            UserList userlist = new UserList();
            UserEdit useredit = new UserEdit();
            UserDelete userdelete = new UserDelete();
            ConsumerAdd consumeradd = new ConsumerAdd();
            
            
            
            //List
            Connection conn = DBConnect.connect(url, user, password, driver, database);
            List<UserListObject> ob = new ArrayList<UserListObject>();
            ob = userlist.Listusername(conn, "mcfly");
            System.out.println(ob.get(0).getEmail());
            System.out.println(ob.get(0).getFirstName());
            conn = DBConnect.connect(url, user, password, driver, database);
            consumeradd.add(conn, ob.get(0).getUserID(), ob.get(0).getUsername(), "07041982", 123442167);
            
            
            //Add
            conn = DBConnect.connect(url, user, password, driver, database);

            useraddData.add(conn, "mcfly", "Marty", "Mcfly", "5551234567", "marty@google.com", "password12");
               
            //Edit
            conn = DBConnect.connect(url, user, password, driver, database);
            useredit.editUsername(conn, 15, "mcflys");
            
            //Delete
            conn = DBConnect.connect(url, user, password, driver, database);
            userdelete.Deleteuser(conn, 14);

            conn.close();
            

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
