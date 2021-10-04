package main.java.homeforus.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        add(c);

        createListingWindow = new CreateListingWindow(this, window);

        newListing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!createListingWindow.isVisible()) {
                    createListingWindow.setVisible(true);
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
