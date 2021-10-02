package main.java.homeforus.gui;

import java.io.IOException;

import main.java.homeforus.core.UserAdd;

public class Connect {

    
    public void glue(NewUserInput realinput) {

        UserAdd adduser = new UserAdd();
        
        try {
            adduser.add(realinput.getUsername(), realinput.getFirstName(), realinput.getLastName(), realinput.getPhone(), realinput.getEmail(), 
                    realinput.getPassword());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
    
    
}
