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
  */

    public static void main(String[] args) {
       
            UIstart uiuser = new UIstart();
            uiuser.createUser();

    }
}
