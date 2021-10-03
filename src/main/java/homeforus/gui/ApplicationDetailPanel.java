package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.awt.*;

public class ApplicationDetailPanel extends DetailPanel{

    main.java.homeforus.gui.BaseWindow window;
    private String buyerName;
    private String status;
    private String daysOld;
    private String address;

    public ApplicationDetailPanel(main.java.homeforus.gui.ApplicationInfo appInfo, main.java.homeforus.gui.BaseWindow window){
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
        daysOld = "Days on HomeForUs: " +appInfo.getDaysOld(); //changed to daysOld because I don't see an address
        address = appInfo.getAddress();

        main.java.homeforus.gui.DetailPanel.getRow1().setText(buyerName);
        main.java.homeforus.gui.DetailPanel.getRow2().setText(status);
        main.java.homeforus.gui.DetailPanel.getRow3().setText(address);
        main.java.homeforus.gui.DetailPanel.getRow4().setText("");
        main.java.homeforus.gui.DetailPanel.getRow5().setText(daysOld);

        if(status.equals("DENIED")){
            main.java.homeforus.gui.DetailPanel.getRow2().setForeground(Color.red);
        }
        if(status.equals("ACCEPTED")){
            main.java.homeforus.gui.DetailPanel.getRow2().setForeground(Color.green);
        }
    }
}
