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
    private ArrayList<ContentPanel> realtorListingsPanels;

    public RealtorListingsView(BaseWindow window, ContentPanelListDisplay c) {
        super(window, c);
        removePanels();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel addNewL = new JPanel();
        JButton newListing = new JButton("Add New Listing");
        add(addNewL);
        addNewL.add(newListing);

        realtorListingsPanels = new ArrayList<>(c.getPanelList());

        for (ContentPanel p:realtorListingsPanels) {
            ButtonAreaManageListings btns = new ButtonAreaManageListings(window, this, ((HouseContentPanel) p).getHouseID());
            btns.setButtonsVisible(true);
            btns.setContentPanelID(p.getPANEL_ID());
            ((HouseContentPanel) p).removeBtnArea();
            p.setBtnArea(btns);
            p.add(p.getBtnArea());
            p.revalidate();
        }
        ContentPanelListDisplay cpld = new ContentPanelListDisplay(realtorListingsPanels);
        add(cpld);

        RealtorListingsView r = this;

        createListingWindow = new CreateListingWindow(r, window);
        newListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!createListingWindow.isVisible()) {
                    createListingWindow.setMinimumSize(new Dimension(500,380));
                    createListingWindow.setLocationRelativeTo(window);
                    createListingWindow.setVisible(true);
                    try {
                        createListingWindow.launchWindow(true, -1, -1);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public ArrayList<ContentPanel> getRealtorListingsPanels() {
        return realtorListingsPanels;
    }

    public CreateListingWindow getCreateListingWindow() {
        return createListingWindow;
    }

    public void setCreateListingWindow(CreateListingWindow createListingWindow) {
        this.createListingWindow = createListingWindow;
    }

    public void hideCreateListingsWindow(CreateListingWindow c) {
        c.setVisible(false);
//        createListingWindow.dispose();
    }

}
