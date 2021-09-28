package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.ApplicationList;
import main.java.homeforus.core.ApplicationListObject;

public class UIRealtorMenu {

    public void realtormenu() throws SQLException {

        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";

        try {
            while (true) {
                System.out.println("Type 1: View Applications");
                System.out.println("Type 2: Approve Applications");
                System.out.println("Type 3: Edit Applications");
                System.out.println("Type Quit: Exit");
                answer = read.readLine();

                if (answer.equals("1")) {
                    realtorviewapplication();
                } else if (answer.equals("2")) {

                } else if (answer.equals("3")) {

                } else if (answer.equals("Quit")) {
                    return;
                } else {
                    System.out.println("Please chose correct option.");
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void realtorviewapplication() throws SQLException, IOException {
        ApplicationList applist = new ApplicationList();

        List<ApplicationListObject> applicationall = new ArrayList<>();
        applicationall = applist.ListAll();
        
        for(int i=0; i< applicationall.size(); i++) {
            System.out.print("House_ID: ");
            System.out.println(applicationall.get(i).getHouseID());
            System.out.print("Consumer_ID: ");
            System.out.println(applicationall.get(i).getConsumerID());
            System.out.print("Consumer_Username: ");
            System.out.println(applicationall.get(i).getConsumerUsername());
            System.out.print("Realtor_ID: ");
            System.out.println(applicationall.get(i).getRealtorID());
            System.out.print("Realtor_Username: ");
            System.out.println(applicationall.get(i).getRealtorUsername());
            System.out.print("Status: ");
            System.out.println(applicationall.get(i).getStatus());
            
            System.out.println("---------------------------------------");
        }
        
    }
}
