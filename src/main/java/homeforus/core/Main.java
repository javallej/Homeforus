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


       
            UserAdd useraddData = new UserAdd();
            UserList userlist = new UserList();
            UserEdit useredit = new UserEdit();
            UserDelete userdelete = new UserDelete();
            ConsumerAdd consumeradd = new ConsumerAdd();
            
            //Connection conn = DBConnect.connect(url, user, password, driver, database);
            
            //Add
            //conn = DBConnect.connect(url, user, password, driver, database);

            //useraddData.add(conn, "mcfly", "Marty", "Mcfly", "5551234567", "marty@google.com", "password12");
            
            //List
            //conn = DBConnect.connect(url, user, password, driver, database);
            //List<UserListObject> ob = new ArrayList<UserListObject>();
            //ob = userlist.Listusername(conn, "mcfly");
            //System.out.println(ob.get(0).getEmail());
            //System.out.println(ob.get(0).getFirstName());

            try {
                consumeradd.add(27, "mcfly", "07232982", 123232167);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            

               
            //Edit
            //conn = DBConnect.connect(url, user, password, driver, database);
            //useredit.editUsername(conn, 15, "mcflys");
            
            //Delete
            //conn = DBConnect.connect(url, user, password, driver, database);
            //userdelete.Deleteuser(conn, 14);

            //conn.close();
            

    }
}
