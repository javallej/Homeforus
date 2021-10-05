package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RealtorListingsView extends ContentView{

    private CreateListingWindow createListingWindow;

    public RealtorListingsView(BaseWindow window, ContentPanelListDisplay c) {
        super(window, c);
        removePanels();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel addNewL = new JPanel();
        JButton newListing = new JButton("Add New Listing");
        add(addNewL);
        addNewL.add(newListing);

        ArrayList<ContentPanel> realtorListingsPanels = new ArrayList<>(c.getPanelList());

        for (ContentPanel p:realtorListingsPanels) {
            ButtonAreaManageListings btns = new ButtonAreaManageListings(window, this, ((HouseContentPanel) p).getHouseID());
            btns.setButtonsVisible(true);
            ((HouseContentPanel) p).removeBtnArea();
            p.setBtnArea(btns);
            p.add(p.getBtnArea());
            p.revalidate();
        }
        ContentPanelListDisplay cpld = new ContentPanelListDisplay(realtorListingsPanels);
        add(cpld);

        createListingWindow = new CreateListingWindow(this, window);

        newListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!createListingWindow.isVisible()) {
                    createListingWindow.setVisible(true);
                    try {
                        createListingWindow.launchWindow(true, -1);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void setCreateListingWindow(CreateListingWindow createListingWindow) {
        this.createListingWindow = createListingWindow;
    }

    public void hideCreateListingsWindow() {
        createListingWindow.setVisible(false);
    }

}
