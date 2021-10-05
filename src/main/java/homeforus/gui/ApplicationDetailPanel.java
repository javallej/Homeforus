package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.awt.*;

public class ApplicationDetailPanel extends DetailPanel{

    BaseWindow window;
    private String buyerName;
    private String status;
    private String daysOld;
    private String address;

    public ApplicationDetailPanel(ApplicationInfo appInfo){
        this.window = window;
        buyerName = appInfo.getFirstName() + " " + appInfo.getLastName();
        status = "<html><font color=black>Status: </font>" + appInfo.getStatus();
        address = appInfo.getAddress();

        getRow1().setText(buyerName);
        getRow2().setText(status);
        getRow3().setText(address);
        getRow4().setText("");
        getRow5().setText("");

        if(status.equals("Denied")){
            getRow2().setForeground(Color.red);
        }
        if(status.equals("Approved")){
            getRow2().setForeground(Color.green);
        }
    }
}
