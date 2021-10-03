package main.java.homeforus.gui;

public class ApplicationDetailPanel extends DetailPanel{

    private String buyerName;
    private String status;
    private String appDate;
    private String address;

    public ApplicationDetailPanel(){

        buyerName = "Joe Shmoe";
        status = "Status: PROCESSING";
        appDate = "Applied: 05/21/2021";
        address = "742 Evergreen Terrace, Springfield, OR, 12345";

        getRow1().setText(buyerName);
        getRow2().setText(status);
        getRow3().setText(address);
        getRow4().setText("");
        getRow5().setText(appDate);

    }
}
