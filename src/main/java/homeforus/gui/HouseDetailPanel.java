package main.java.homeforus.gui;

public class HouseDetailPanel extends DetailPanel {

    private String price;
    private String details;
    private String address;
    private String year_built;
    private String daysOn;
    private int numDays;

    public HouseDetailPanel(){

        price = "$123,000";
        details = "2 bds 1ba 2 floors 1,500 sqft";
        address = "742 Evergreen Terrace, Springfield, OR, 12345";
        year_built = "Year built: 1952";
        numDays = 52;
        daysOn = numDays + " days on HomeForUs";

        getRow1().setText(price);
        getRow2().setText(details);
        getRow3().setText(address);
        getRow4().setText(year_built);
        getRow5().setText(daysOn);

    }

}
