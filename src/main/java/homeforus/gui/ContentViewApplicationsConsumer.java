package main.java.homeforus.gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContentViewApplicationsConsumer extends ContentView {

    ArrayList<ApplicationInfo> appInfoList;
    private ContentPanelListDisplay contentPanelListDisplay;

    public ContentViewApplicationsConsumer(BaseWindow window) {
        super(window);
        try {
            appInfoList = window.getQueryConnector().getAppList();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // populate the contentPanelListDisplay object with
        // the list of application info from appInfoList
        // it will be filled with ContentPanels that match the view in the UI
        // mockup that show the "Applications View Consumer" panels

    }
}
