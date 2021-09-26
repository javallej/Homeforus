package main.java.homeforus.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Setup {
    
    public static HashMap<String, String> setup() throws IOException {
        
        try (InputStream input = RDBMconnect.class.getClassLoader().getResourceAsStream("rdbm.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Unable to find rdbm.properties file!");
            }

            prop.load(input);

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

}
