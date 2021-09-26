/*
  File: RDBMConnect.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Gets information from properties file.
*/

package main.java.homeforus.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
Class: RDBMconnect    
 
Description: Gets information from properties file.
*/

public class RDBMconnect {

    private Properties prop = new Properties();

    /**
    Method: PropConnector
    Inputs: void
    Returns: Object

    Description: Creates object for connection information.
  */

    
    public Object PropConnector() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("rdbm.properties")) {

            if (input == null) {
                System.out.println("Unable to find rdbm.properties file!");
                return null;
            }

            prop.load(input);

        }

        catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;

    }

    /**
    Method:getDriver
    Inputs: void
    Returns: String

    Description: Gets the database driver.
  */

    public String getDriver() {
        return prop.getProperty("jdbcDriver");
    }

    /**
    Method: getServer
    Inputs: void
    Returns: String

    Description: Gets the URL of the database.
  */

    public String getServer() {
        return prop.getProperty("jdbcUrl");
    }

    /**
    Method: getUser
    Inputs: void
    Returns: String

    Description: Gets user information for database login.
  */

    public String getUser() {
        return prop.getProperty("jdbcUser");
    }

    /**
    Method: getPassword
    Inputs: void
    Returns: String

    Description: Gets password for database login.
  */

    public String getPassword() {
        return prop.getProperty("jdbcPasswd");
    }
}
