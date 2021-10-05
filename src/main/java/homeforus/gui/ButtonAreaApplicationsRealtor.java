package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAreaApplicationsRealtor extends ButtonArea {

    private ApplicationListObject applicationListObject;

    public ButtonAreaApplicationsRealtor(BaseWindow window, ApplicationListObject applicationListObject) {
        super(window);
        this.applicationListObject = applicationListObject;
        int houseID = applicationListObject.getHouseID();
        int consumerID = applicationListObject.getConsumerID();
        int realtorID = applicationListObject.getRealtorID();


        getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Call to Approve Application in QueryConnector");
                window.getQueryConnector().approveApplication(houseID,consumerID,realtorID);
            }
        });

        getBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("call to Deny Application in QueryConnector");
                window.getQueryConnector().denyApplication(houseID, consumerID, realtorID);
            }
        });

        getBtn1().setText("Approve");
        getBtn2().setText("Cancel");
        setButtonsVisible(true);


    }

}
