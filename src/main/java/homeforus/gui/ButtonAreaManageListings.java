package main.java.homeforus.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ButtonAreaManageListings extends ButtonArea {

    private int houseID;
    private CreateListingWindow updateListingWindow;
    private int contentPanelID;

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
                    updateListingWindow.setMinimumSize(new Dimension(500, 350));
                    updateListingWindow.setLocationRelativeTo(window);
                    updateListingWindow.setVisible(true);
                    try {
                        updateListingWindow.launchWindow(false, houseID, contentPanelID);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        getBtn2().setText("Delete Listing");
        // call Delete listing here
        getBtn2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getQueryConnector().deleteHouse(houseID);
                QueryConnector q = window.getQueryConnector();
                ArrayList<HouseContentPanel> realtorsHouses = null;
                try {
                    realtorsHouses = q.getRealtorHouses(q.getCurrentlyLoggedInUser().getUserID());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (realtorsHouses != null) {
                    ArrayList<ContentPanel> cH = new ArrayList<>(realtorsHouses);
                    ContentPanelListDisplay h = new ContentPanelListDisplay(cH);
                    RealtorListingsView r = new RealtorListingsView(window, h);
                    window.setContentView(r);
                }
            }
        });
        setButtonsVisible(true);
    }

    public int getContentPanelID() {
        return contentPanelID;
    }

    public void setContentPanelID(int contentPanelID) {
        this.contentPanelID = contentPanelID;
    }

    public int getHouseID() {
        return houseID;
    }
}
