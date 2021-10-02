/*
  File: Setup.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Reads Properties file and passes to HashMap. 
*/

package main.java.homeforus.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Class: Setup
 * 
 * Description: Reads Properties file and passes to HashMap.
 */
public class Setup {

    /**
     * Method: setup Inputs: void Returns: HashMap<String, String>
     * 
     * Description: Reads Properties file and passes to HashMap.
     */

    public static HashMap<String, String> setup() throws IOException {

        Properties prop = new Properties();
        FileInputStream in = null;

        String propPath = System.getProperty("config");

        if (propPath != null) {
            in = new FileInputStream(propPath);
            try {
                prop.load(in);
            } finally {
                if (propPath != null) {
                in.close();
                }
            }
        }
        else {
            try (InputStream input = RDBMconnect.class.getClassLoader().getResourceAsStream("rdbm.properties")) {

                if (input == null) {
                    System.out.println("Unable to find rdbm.properties file!");
                }

                prop.load(input);
            }
        }



        HashMap<String, String> connectioninfo = new HashMap<String, String>();

        String driver = prop.getProperty("jdbcDriver");
        String url = prop.getProperty("jdbcUrl");
        String user = prop.getProperty("jdbcUser");
        String password = prop.getProperty("jdbcPasswd");

        connectioninfo.put("jdbcDriver", driver);
        connectioninfo.put("jdbcUrl", url);
        connectioninfo.put("jdbcUser", user);
        connectioninfo.put("jdbcPasswd", password);

        return connectioninfo;
    }

}
