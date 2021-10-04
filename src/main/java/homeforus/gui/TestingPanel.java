package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class TestingPanel extends JPanel {

    BaseWindow window;
    CreateListingWindow listingWindow;
    ImageTesterWindow imgWindow;
    HouseDetailWindow houseDetailPopUp;

    public TestingPanel(BaseWindow window) {

        this.window = window;
        setPreferredSize(new Dimension(540,130));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JButton addNewListing = new JButton("Edit listing");
        add(addNewListing);
        RealtorListingsView r = new RealtorListingsView();

        // Create the CreateListingWindow window here
        // Remember it's going to have to be passed the HouseID and/or all the House
        // information from whatever house you're using it to edit when you create it so it can
        // auto-populate those fields when it launches.
        // So maybe make a new CreateHouseListing constructor in the class that accepts that stuff from here.
        listingWindow = new CreateListingWindow(r,window);
        r.setCreateListingWindow(listingWindow);

        addNewListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listingWindow.isVisible()) {
                    listingWindow.setVisible(true);
                }
                try {
                    /*
                    THIS IS WHERE YOU WOULD NEED TO FETCH THE ACTUAL
                    HOUSE ID FOR THE HOUSE THE BUTTON IS NEXT TO!!!!
                    CURRENTLY USING HARDCODED HOUSE ID OF 2 FOR TESTING!!!
                    */
                    listingWindow.populateHouseData(2);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
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





    }
}
