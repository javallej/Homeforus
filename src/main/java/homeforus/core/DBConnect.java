package main.java.homeforus.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    
    public static Connection connect(String url, String user, String password, String driver) {

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
