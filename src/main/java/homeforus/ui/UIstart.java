package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.ConsumerAdd;
import main.java.homeforus.core.RealtorAdd;
import main.java.homeforus.core.UserAdd;
import main.java.homeforus.core.UserList;
import main.java.homeforus.core.UserListObject;

public class UIstart {
    
    public void console() throws SQLException {
        
        UIcreateUser create = new UIcreateUser();
        UIlogin login = new UIlogin();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        
        try {
            while(true)
            {
                System.out.println("Type 1: Create an Account");
                System.out.println("Type 2: Login");
                System.out.println("Type Quit: Exit");
                answer = read.readLine();
                
                if(answer.equals("1")) {
                    create.createUser();
                }
                else if (answer.equals("2")) {
                    login.login();
                }
                else if (answer.equals("Quit")) {
                   return;
                }
                else {
                    System.out.println("Please chose correct option.");
                }
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}
