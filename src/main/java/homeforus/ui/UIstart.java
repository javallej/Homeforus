package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.RealtorAdd;
import main.java.homeforus.core.UserAdd;
import main.java.homeforus.core.UserList;
import main.java.homeforus.core.UserListObject;

public class UIstart {

    public void createUser() {
        

        try {
            UserAdd adduser = new UserAdd();
            UserList listuser = new UserList();
            ArrayList<String> userlist = new ArrayList<String>();
            List<UserListObject> ulist;
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String realtor = "";
            String realtorbusinessname = "";
            
            System.out.println("Please enter a Username.");
            userlist.add(read.readLine());
            System.out.println("Please enter a First Name.");
            userlist.add(read.readLine());
            System.out.println("Please enter a Last Name.");
            userlist.add(read.readLine());
            System.out.println("Please enter a Phone Number.");
            userlist.add(read.readLine());
            System.out.println("Please enter a Email.");
            userlist.add(read.readLine());
            System.out.println("Please enter a Password.");
            userlist.add(read.readLine());
 
            adduser.add(userlist.get(0).toString(), userlist.get(1).toString(), userlist.get(2).toString(),
                    userlist.get(3).toString(), userlist.get(4).toString(), userlist.get(5).toString());
            
            System.out.println("Do you want to be a Realtor?");
            realtor = read.readLine();

            if(realtor.equals("yes") || realtor.equals("Yes")) {
                try {
                    System.out.println("What is your business name?");
                    realtorbusinessname = read.readLine();
                    ulist = listuser.Listusername(userlist.get(0));
                    
                    createRealtor(ulist.get(0).getUserID(),ulist.get(0).getUsername(), realtorbusinessname);

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
                
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    
    public void createRealtor(int Realtor_ID, String Realtor_Username, String Business_Name) {
        RealtorAdd addRealtor =  new RealtorAdd();
        try {
            addRealtor.add(Realtor_ID, Realtor_Username, Business_Name);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void createConsumer() {
        
    }
    
}
