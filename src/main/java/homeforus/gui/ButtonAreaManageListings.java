package main.java.homeforus.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class ButtonAreaManageListings extends ButtonArea {

    private int houseID;
    private CreateListingWindow updateListingWindow;

    public ButtonAreaManageListings(BaseWindow window, RealtorListingsView realtorListingsView, int houseID) {
        super(window);
        this.houseID = houseID;
        getBtn1().setText("Update Listing");

        updateListingWindow = new CreateListingWindow(realtorListingsView,window);

        // Update Listing window called here
        getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!updateListingWindow.isVisible()) {
                    updateListingWindow.setVisible(true);
                }
                try {
                    updateListingWindow.populateHouseData(houseID);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        getBtn2().setText("Delete Listing");

        // call Delete listing here
        getBtn1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setButtonsVisible(true);
    }

    public int getHouseID() {
        return houseID;
    }
}
