package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import main.java.homeforus.core.ApplicationAdd;

public class UIConsumerMenu {

    public void consumermenu() throws SQLException {

        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";

        try {
            while (true) {
                System.out.println("Type 1: Search Houses");
                System.out.println("Type 2: Submit an Application");
                System.out.println("Type Quit: Exit");
                answer = read.readLine();

                if (answer.equals("1")) {
                    consumersearch();
                } else if (answer.equals("2")) {
                    consumerapplicationadd();
                } else if (answer.equals("Quit")) {
                    return;
                } else {
                    System.out.println("Please chose correct option.");
                }
            

            }} catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void consumersearch() {

    }

    public void consumerapplicationadd() throws IOException {
        
        ApplicationAdd appadd = new ApplicationAdd();
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String house_id = "";
        String consumer_id = "";
        String consumer_username = "";
        String realtor_id = "";
        String realtor_username = "";
        String status = "";
        
        int ihouse_id;
        int iconsumer_id;
        int irealtor_id;

        
        System.out.println("Enter the House_Id");
        house_id = read.readLine();
        System.out.println("Enter the Consumer_Id");
        consumer_id = read.readLine();
        System.out.println("Enter the Consumer_Username");
        consumer_username = read.readLine();
        System.out.println("Enter the Realtor_Id");
        realtor_id = read.readLine();
        System.out.println("Enter the Realtor_Username");
        realtor_username = read.readLine();
        System.out.println("Enter the Status");
        status = read.readLine();
        
        
        ihouse_id = Integer.parseInt(house_id);
        iconsumer_id = Integer.parseInt(consumer_id);
        irealtor_id = Integer.parseInt(realtor_id);
        
        appadd.add(ihouse_id, iconsumer_id, consumer_username, irealtor_id, realtor_username, status);
    }
}
