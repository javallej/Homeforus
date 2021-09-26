package main.java.homeforus.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RDBMconnect {

    private Properties prop = new Properties();

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

    public String getDriver() {
        return prop.getProperty("jdbcDriver");
    }

    public String getServer() {
        return prop.getProperty("jdbcUrl");
    }

    public String getUser() {
        return prop.getProperty("jdbcUser");
    }

    public String getPassword() {
        return prop.getProperty("jdbcPasswd");
    }
}
