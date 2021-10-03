package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAreaApplicationsConsumer extends ButtonArea {

    private ApplicationListObject applicationListObject;

    public ButtonAreaApplicationsConsumer(BaseWindow window, ApplicationListObject applicationListObject) {
        super(window);
        this.applicationListObject = applicationListObject;

        JButton cancel = new JButton("Cancel");

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("call to Deny Application in QueryConnector");
            }
        });

        setBtn1(cancel);
        getBtn1().setVisible(true);

    }

}
