package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;

import main.java.homeforus.core.Login;

public class UIlogin {
    
    public void login() throws SQLException {
        
        UIcreateUser create = new UIcreateUser();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        
        try {
            while(true)
            {
                System.out.println("Type 1: Realtor Login");
                System.out.println("Type 2: User Login");
                System.out.println("Type Quit: Exit");
                answer = read.readLine();
                
                if(answer.equals("1")) {
                    Realtorlogin();
                }
                else if (answer.equals("2")) {
                    Userlogin();
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
    
    public void Realtorlogin() throws SQLException {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> Userchecklogin = new HashMap<String, String>();
        HashMap<String, String> Databasechecklogin = new HashMap<String, String>();
        Login check = new Login();
        String username = "";
        String password = "";
        String answer = "";
        
        try {
            while(true)
            {
                System.out.println("Type Username");
                username = read.readLine();
                Userchecklogin.put("username", username);
                System.out.println("Type Password");
                password = read.readLine();
                Userchecklogin.put("password", password);
                
                Databasechecklogin = check.logincheckRealtor(username);
                
                if(Databasechecklogin.equals(Userchecklogin)) {
                    UIRealtorMenu realtor = new UIRealtorMenu();
                    realtor.realtormenu();
                }
                else {
                System.out.println("Please enter correct information.");
                System.out.println("Type 1 to try again.");
                System.out.println("Type 2 to return to main menu.");
                answer = read.readLine();
                
                if (answer.equals("2"))
                {
                    return;
                }
                }
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public void Userlogin() {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> Userchecklogin = new HashMap<String, String>();
        HashMap<String, String> Databasechecklogin = new HashMap<String, String>();
        Login check = new Login();
        String username = "";
        String password = "";
        
        try {
            while(true)
            {
                System.out.println("Type Username");
                username = read.readLine();
                Userchecklogin.put("username", username);
                System.out.println("Type Password");
                password = read.readLine();
                Userchecklogin.put("password", password);
                
                Databasechecklogin = check.logincheck(username);
                
                if(Databasechecklogin.equals(Userchecklogin)) {
                    System.out.println("Your a hacker!");
                }
                else {
                System.out.println("Please enter correct information.");
                }
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
