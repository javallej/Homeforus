package main.java.homeforus.gui;

import main.java.homeforus.core.HouseListObject;
import java.text.NumberFormat;
import java.util.Locale;

public class HouseDetailPanel extends DetailPanel {

    private int houseID;
    private String price;
    private String details;
    private String address;
    private String year_built;
    private String daysOn;
    private int numDays;

    private String state;
    private String city;
    private String zip;
    private String street;
    private int house_number;
    private int cost;
    private int year;
    private int num_floors;
    private int num_bed;
    private int num_bath;
    private int sqr_feet;
    private int days_listed;

    public HouseDetailPanel(HouseListObject houseListObject){

        houseID = houseListObject.getHouseID();
        cost = houseListObject.getCost();
        num_bed = houseListObject.getNumBed();
        num_bath = houseListObject.getNumBath();
        num_floors = houseListObject.getNumFloors();
        sqr_feet = houseListObject.getSqrFeet();
        house_number = houseListObject.getHouseNumber();
        street = houseListObject.getStreet();
        state = houseListObject.getState();
        city = houseListObject.getCity();
        zip = houseListObject.getZip();
        year = houseListObject.getYear();
        days_listed = houseListObject.getDaysListed();

        //Test Values
//        houseID = 69;
//        cost = 123456;
//        num_bed = 2;
//        num_bath = 1;
//        num_floors = 2;
//        sqr_feet = 1500;
//        house_number = 742;
//        street = "Evergreen Terrace";
//        state = "OR";
//        city = "SpringField";
//        zip = "12345";
//        year = 1952;
//        days_listed = 52;

        // Set the fields and concatenate the text in the labels appropriately
        // eg:
        price = NumberFormat.getCurrencyInstance(new Locale("en","US")).format(cost);
        details = num_bed + " beds " + num_bath + " baths " + num_floors + " floors " + sqr_feet + " sqft";
        address = house_number + " " + street + ", " + city + ", " + state + ", " + zip;
        year_built = "Year built: " + year;
        daysOn = "Days on HomeForUs: " + days_listed;

        getRow1().setText(price);
        getRow2().setText(details);
        getRow3().setText(address);
        getRow4().setText(year_built);
        getRow5().setText(daysOn);

    }

}
