package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationsView extends ContentView {

    ArrayList<ApplicationInfo> appInfoList;
    ArrayList<ApplicationListObject> appList;
    private ContentPanelListDisplay contentPanelListDisplay;

    public ApplicationsView(BaseWindow window) {
        super(window);
        QueryConnector query = window.getQueryConnector();
        int userID = query.getCurrentlyLoggedInUser().getUserID();
        boolean isRealtor = query.getCurrentlyLoggedInUser().isRealtor();

        ArrayList<ApplicationContentPanel> panels = null;
        try {
            panels = window.getQueryConnector().getAppContentPanels(isRealtor, userID);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (panels != null) {
            ArrayList<ContentPanel> contentPanels = new ArrayList<>(panels);
            contentPanelListDisplay = new ContentPanelListDisplay(contentPanels);
            add(contentPanelListDisplay);
        } else {
            add(new JLabel("No applications found."));
        }
    }
}
