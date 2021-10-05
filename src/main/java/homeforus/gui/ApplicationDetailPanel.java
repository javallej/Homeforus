package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.awt.*;

public class ApplicationDetailPanel extends DetailPanel{

    BaseWindow window;
    private String buyerName;
    private String status;
    private String daysOld;
    private String address;

    public ApplicationDetailPanel(ApplicationInfo appInfo, BaseWindow window){
        this.window = window;
//        buyerName = "Joe Shmoe";
//        status = "Status: PROCESSING";
//        appDate = "Applied: 05/21/2021";
//        address = "742 Evergreen Terrace, Springfield, OR, 12345";


        // Set the fields and concatenate the text in the labels appropriately from appInfo's fields
        // eg.
        buyerName = appInfo.getFirstName() + " " + appInfo.getLastName();
        status = "<html><font color=black>Status: </font>" + appInfo.getStatus();
        // and so on...
        address = appInfo.getAddress();

        getRow1().setText(buyerName);
        getRow2().setText(status);
        getRow3().setText(address);
        getRow4().setText("");
        getRow5().setText("");

        if(status.equals("DENIED")){
            getRow2().setForeground(Color.red);
        }
        if(status.equals("ACCEPTED")){
            getRow2().setForeground(Color.green);
        }
    }
}
