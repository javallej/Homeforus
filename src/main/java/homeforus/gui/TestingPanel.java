package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestingPanel extends JPanel {

    BaseWindow window;
    CreateListingWindow listingWindow;
    ImageTesterWindow imgWindow;
    HouseDetailWindow houseDetailPopUp;

    public TestingPanel(BaseWindow window) {

        this.window = window;
        setPreferredSize(new Dimension(540,130));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton addNewListing = new JButton("Add New Listing");
        add(addNewListing);
        RealtorListingsView r = new RealtorListingsView();
        listingWindow = new CreateListingWindow(r,window);

        addNewListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listingWindow.isVisible()) {
                    listingWindow.setVisible(true);
                }
            }
        });

        JButton imageTester = new JButton("Image Tester");
        add(imageTester);
        imgWindow = new ImageTesterWindow();

        imageTester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!imgWindow.isVisible()) {
                    imgWindow.setVisible(true);
                }
            }
        });


        JButton houseDetailTester = new JButton("House Detail Tester");
        add(houseDetailTester);
        HouseDetailPanel houseDetailPanel = new HouseDetailPanel(null);
        houseDetailPopUp = new HouseDetailWindow(window, houseDetailPanel);

        houseDetailTester.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!houseDetailPopUp.isVisible()) {
                    houseDetailPopUp.setVisible(true);
                }
            }
        });

    }
}
