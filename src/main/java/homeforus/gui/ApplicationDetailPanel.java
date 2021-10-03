package main.java.homeforus.gui;

import java.awt.*;

public class ApplicationDetailPanel extends DetailPanel{

    private String buyerName;
    private String status;
    private String appDate;
    private String address;

    public ApplicationDetailPanel(){

        buyerName = "Joe Shmoe";
        status = "ACCEPTED";
        appDate = "05/21/2021";
        address = "742 Evergreen Terrace, Springfield, OR, 12345";

        getRow1().setText(buyerName);
        getRow2().setText("<html><font color=black>Status: </font>" + status);
        getRow3().setText(address);
        getRow4().setText("");
        getRow5().setText("Applied: " + appDate);

        if(status.equals("DENIED")){
            getRow2().setForeground(Color.red);
        }
        if(status.equals("ACCEPTED")){
            getRow2().setForeground(Color.green);
        }
    }
}
