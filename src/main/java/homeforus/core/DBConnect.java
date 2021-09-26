/*
  File: DBConnect.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Sets up a connection to the database.
*/

package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.DriverManager;

/**
Class: DBConnect 

Description: Sets up a connection to the database.
*/
public class DBConnect {
    
    /**
    Method: connect
    Inputs: String url, String user, String password, String driver, String database
    Returns: Connection

    Description: Sets up a connection to the database.
  */
    public static Connection connect(String url, String user, String password, String driver, String database) {

        Connection conn = null;

        try {

            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);

        }

        catch (Exception exc) {
            exc.printStackTrace();
        }

        return conn;

    }

}
