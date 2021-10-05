package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationsView extends ContentView {

    ArrayList<ApplicationInfo> appInfoList;
    ArrayList<ApplicationListObject> appList;
    private ContentPanelListDisplay contentPanelListDisplay;

    public ApplicationsView(BaseWindow window, ContentPanelListDisplay c) {
        super(window);
        this.contentPanelListDisplay = c;
//        try {
//            appInfoList = window.getQueryConnector().getAppList();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




        add(contentPanelListDisplay);

    }
}
