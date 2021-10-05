package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
        setButtonsVisible(true);
        getBtn1().setVisible(true);
        System.out.println(getBtn1().isVisible());

        getBtn1().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                System.out.println("button 1 shown");
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
                System.out.println("button 1 hidden by: " + e.getSource());
            }
        });



        setBorder(new MatteBorder(1,1,1,1, Color.CYAN));

    }

}
