package main.java.homeforus.gui;

import main.java.homeforus.core.HouseListObject;

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

//        houseID = 69;
//        price = "$123,000";
//        details = "2 bds 1ba 2 floors 1,500 sqft";
//        address = "742 Evergreen Terrace, Springfield, OR 12345";
//        year_built = "Year built: 1952";
//        numDays = 52;
//        daysOn = numDays + " days on HomeForUs";

        // Create HouseListObject for testing using all the info you just put in up there
        //HouseListObject houseObj = new HouseListObject();

        houseID = houseListObject.getHouseID();
        cost = houseListObject.getCost();
        num_bed = houseListObject.getNumBed();
        num_bath = houseListObject.getNumBath();
        num_floors = houseListObject.getNumFloors();
        sqr_feet = houseListObject.getSqrFeet();
        house_number = houseListObject.getHouseNumber();
        state = houseListObject.getState();
        city = houseListObject.getCity();
        zip = houseListObject.getZip();
        year = houseListObject.getYear();
        days_listed = houseListObject.getDaysListed();

        // Set the fields and concatenate the text in the labels appropriately
        // eg:
        price = "$" + cost;
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
