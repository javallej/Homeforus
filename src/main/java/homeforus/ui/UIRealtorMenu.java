package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.ApplicationDelete;
import main.java.homeforus.core.ApplicationEdit;
import main.java.homeforus.core.ApplicationList;
import main.java.homeforus.core.ApplicationListObject;
import main.java.homeforus.core.HouseDelete;
import main.java.homeforus.core.HouseEdit;

public class UIRealtorMenu {

    public void realtormenu() throws SQLException {

        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";

        try {
            while (true) {
                System.out.println("Type 1: View Applications");
                System.out.println("Type 2: Approve Applications");
                System.out.println("Type 3: Delete Applications");
                System.out.println("Type 4: Delete House");
                System.out.println("Type 5: Edit House");
                System.out.println("Type Quit: Exit");
                answer = read.readLine();

                if (answer.equals("1")) {
                    realtorviewapplication();
                } else if (answer.equals("2")) {
                    realtorapproveapplication();
                } else if (answer.equals("3")) {
                    realtordeleteapplication();
                } else if (answer.equals("4")) {
                    realtordeletehouse();
                } else if (answer.equals("5")) {
                    realtoredithouse();
                } 
                else if (answer.equals("Quit")) {
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
    public void realtorapproveapplication() throws SQLException, IOException {
        ApplicationEdit appEdit = new ApplicationEdit();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String house_id = "";
        String consumer_id = "";
        String realtor_id = "";
        
        int ihouse_id;
        int iconsumer_id;
        int irealtor_id;

        
        System.out.println("Enter the House_Id");
        house_id = read.readLine();
        System.out.println("Enter the Consumer_Id");
        consumer_id = read.readLine();
        System.out.println("Enter the Realtor_Id");
        realtor_id = read.readLine();
        
        
        ihouse_id = Integer.parseInt(house_id);
        iconsumer_id = Integer.parseInt(consumer_id);
        irealtor_id = Integer.parseInt(realtor_id);
        
        
        appEdit.editStatus("Approved", ihouse_id, iconsumer_id, irealtor_id);
        
        return;

    }
    
    public void realtordeleteapplication() throws SQLException, IOException {
        
        ApplicationDelete appDelete = new ApplicationDelete();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        String house_id = "";
        String consumer_id = "";
        String realtor_id = "";
        
        int ihouse_id;
        int iconsumer_id;
        int irealtor_id;

        
        System.out.println("Enter the House_Id");
        house_id = read.readLine();
        System.out.println("Enter the Consumer_Id");
        consumer_id = read.readLine();
        System.out.println("Enter the Realtor_Id");
        realtor_id = read.readLine();
        
        
        ihouse_id = Integer.parseInt(house_id);
        iconsumer_id = Integer.parseInt(consumer_id);
        irealtor_id = Integer.parseInt(realtor_id);
        
        appDelete.delete(ihouse_id, iconsumer_id, irealtor_id);

    }
    
    public void realtoredithouse() throws IOException {
        
        HouseEdit houseEdit = new HouseEdit();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String house_id = "";
        String price = "";
        int ihouse_id;
        int cost;
        System.out.println("Enter the House_Id to Edit.");
        house_id = read.readLine();
        ihouse_id = Integer.parseInt(house_id);
        System.out.println("Update the Price.");
        price = read.readLine();
        cost = Integer.parseInt(price);
        houseEdit.editCost(cost, ihouse_id);

            
    }
    
    public void realtordeletehouse() throws IOException {
        
        HouseDelete houseDelete = new HouseDelete();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String house_id = "";
        int ihouse_id;
        System.out.println("Enter the House_Id to delete.");
        house_id = read.readLine();
        ihouse_id = Integer.parseInt(house_id);
        
        houseDelete.delete(ihouse_id);
    }
}
