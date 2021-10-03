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

    public HouseDetailPanel(HouseListObject houseListObject){

//        houseID = 69;
//        price = "$123,000";
//        details = "2 bds 1ba 2 floors 1,500 sqft";
//        address = "742 Evergreen Terrace, Springfield, OR 12345";
//        year_built = "Year built: 1952";
//        numDays = 52;
//        daysOn = numDays + " days on HomeForUs";

        // Create HouseListObject for testing using all the info you just put in up there
        // houseObj = new HouseListObject(houseID, state, city, etc... check HouseListObject constructor);

        // Set the fields and concatenate the text in the labels appropriately
        // eg:
//        price = "$" + houseObj.getCost(); // can use a NumberFormat Java class if you want to format it with the comma and as a price automatically
//        details = houseObj.getNum_bed() + " bds " + houseObj.getNum_bath() + " ba " .... etc

        getRow1().setText(price);
        getRow2().setText(details);
        getRow3().setText(address);
        getRow4().setText(year_built);
        getRow5().setText(daysOn);

    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }
}
