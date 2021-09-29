package main.java.homeforus.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.homeforus.core.ApplicationListObject;
import main.java.homeforus.core.HouseList;
import main.java.homeforus.core.HouseListObject;

public class HouseSearch {

    HouseList houselist = new HouseList(); 
    
    public void PriceSearch() throws IOException, SQLException {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        int icost;
        List<HouseListObject> housecostmax = new ArrayList<>();

        
        System.out.println("Enter max amount.");
        answer = read.readLine();
        icost = Integer.parseInt(answer);
        
        houselist.ListPriceMax(icost);
        housecostmax = houselist.ListPriceMax(icost);
        System.out.println("Houses are: ");
        for(int i=0; i< housecostmax.size(); i++) {
           
           System.out.print("HouseID: ");
           System.out.println(housecostmax.get(i).getHouseID());

           System.out.print("RealtorID: ");
           System.out.println(housecostmax.get(i).getRealtorID());
           
           System.out.print("Realtor Username: ");
           System.out.println(housecostmax.get(i).getRealtorUsername());
           
           System.out.print("State: ");
           System.out.println(housecostmax.get(i).getState());
           
           System.out.print("City: ");
           System.out.println(housecostmax.get(i).getCity());
           
           System.out.print("Zip: ");
           System.out.println(housecostmax.get(i).getZip());
           
           System.out.print("Street: ");
           System.out.println(housecostmax.get(i).getStreet());
           
           System.out.print("House Number: ");
           System.out.println(housecostmax.get(i).getHouseNumber());
           
           System.out.print("Cost: ");
           System.out.println(housecostmax.get(i).getCost());
           
           System.out.print("Year: ");
           System.out.println(housecostmax.get(i).getYear());
           
           System.out.print("Number of Floors: ");
           System.out.println(housecostmax.get(i).getNumFloors());
           
           System.out.print("Number of Beds: ");
           System.out.println(housecostmax.get(i).getNumBed());
           
           System.out.print("Number of Baths: ");
           System.out.println(housecostmax.get(i).getNumBath());
           
           System.out.print("Square Feet: ");
           System.out.println(housecostmax.get(i).getSqrFeet());
           
           System.out.print("Days Listed: ");
           System.out.println(housecostmax.get(i).getDaysListed());
           
           System.out.println("---------------------------------------");
           
        }
        
    }
    
    public void NumberofBedSearch() {
        
    }
}
