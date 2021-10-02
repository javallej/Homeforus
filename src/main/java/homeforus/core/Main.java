/*
  File: Main.java
  Author: SER322 Group 9
  Date: 09/26/2021
  
  Description: Main program for homeforus.
*/

package main.java.homeforus.core;

import java.sql.SQLException;
import java.io.IOException;
import main.java.homeforus.gui.GUIStart;
import main.java.homeforus.ui.UIstart;

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
     * @throws SQLException
     * @throws IOException 
     */

    public static void main(String[] args) throws SQLException, IOException {

        if (args[0].equals("console"))
        {
            UIstart uiuser = new UIstart();
            uiuser.console();
        }
        else if (args[0].equals("gui"))
        {
            GUIStart guistart = new GUIStart();
            guistart.start();
        }
        else {
            System.out.println("Syntax is:");
            System.out.println("java -Dconfig=/path/rdbm.properties -jar homeforus-5.0.jar gui");
            System.out.println("or");
            System.out.println("java -Dconfig=/path/rdbm.properties -jar homeforus-5.0.jar console");
        }
    }
}
