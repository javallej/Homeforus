/*
  File: Main.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Main program for homeforus.
*/

package main.java.homeforus.core;

import java.sql.SQLException;

import main.java.homeforus.ui.UIstart;

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
     * @throws SQLException 
  */

    public static void main(String[] args) throws SQLException {
       
            UIstart uiuser = new UIstart();
            uiuser.console();

    }
}
