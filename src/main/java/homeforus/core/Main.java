package main.java.homeforus.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

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

            Connection conn = DBConnect.connect(url, user, password, driver, database);
            
            //UserList userlist = new UserList();
            UserEdit useredit = new UserEdit();
            UserDelete userdelete = new UserDelete();
            //List<UserListObject> ob = new ArrayList<UserListObject>();
            
            //ob = userlist.Listusername(conn, "doc");
            
            
            //useraddData.add(conn, "mcfly", "Marty", "Mcfly", "5551234567", "marty@google.com", "password12");
               
            //conn = DBConnect.connect(url, user, password, driver, database);
            
            useredit.editUsername(conn, 13, "mcflys");
            conn = DBConnect.connect(url, user, password, driver, database);
            
            userdelete.Deleteuser(conn, 13);

            conn.close();
            

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
