package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationsView extends ContentView {

    ArrayList<ApplicationInfo> appInfoList;
    ArrayList<ApplicationListObject> appList;
    private ContentPanelListDisplay contentPanelListDisplay;

    public ApplicationsView(BaseWindow window) {
        super(window);
//        try {
//            appInfoList = window.getQueryConnector().getAppList();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // TODO: change dummy appInfo object to use the convert method in QueryConnector
        ApplicationInfo appInfo = new ApplicationInfo("Kirry", "Chan", "Submitted", "123 Fake St, Houston, TX 12345");
        ArrayList<ApplicationInfo> appInfoList = new ArrayList<>();
        appInfoList.add(appInfo);

//        ApplicationContentPanel panel1 = new ApplicationContentPanel();

        ArrayList<ContentPanel> panels = new ArrayList<>();

//        ContentPanelListDisplay cpld = new ContentPanelListDisplay();


    }
}
