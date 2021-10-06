/*
  File: Main.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Main program for homeforus.
*/

package main.java.homeforus.core;

import main.java.homeforus.gui.GUIStart;

/**
 * Class: Main
 * 
 * Description: Start of program.
 */

public class Main {

    /**
     * Method: main Inputs: String[] args Returns: void
     * 
     * Description: Start of program.
     * 
     */

    public static void main(String[] args) {
        
        String database = System.getProperty("PrepareDatabase");
        
        if(database != null) {
            PrepareDatabase data= new PrepareDatabase();
            data.prepare(database);
            System.exit(0);
 
        }
        
        GUIStart guistart = new GUIStart();
        guistart.start();
        }
        
    }
