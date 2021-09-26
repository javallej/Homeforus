package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.java.homeforus.core.UserAdd;

public class UIstart {

    public void createUser() {
        

        try {
            UserAdd adduser = new UserAdd();
            ArrayList<String> userlist = new ArrayList<String>();
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            
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
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    
}
