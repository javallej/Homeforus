package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class ButtonAreaApplicationsConsumer extends ButtonArea {

    private ApplicationListObject applicationListObject;

    public ButtonAreaApplicationsConsumer(BaseWindow window, ApplicationListObject applicationListObject) {
        super(window);
        this.applicationListObject = applicationListObject;
        int houseID = applicationListObject.getHouseID();
        int consumerID = applicationListObject.getConsumerID();
        int realtorID = applicationListObject.getRealtorID();


        getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null,"Application is Denied");
                window.getQueryConnector().denyApplication(houseID, consumerID, realtorID);
            }
        });

        getBtn1().setText("Cancel");
        setButtonsVisible(true);
        getBtn2().setVisible(false);


    }

}
