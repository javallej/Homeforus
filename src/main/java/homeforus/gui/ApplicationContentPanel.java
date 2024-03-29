package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;
import main.java.homeforus.core.CurrentlyLoggedInUser;

public class ApplicationContentPanel extends ContentPanel {

    private ApplicationDetailPanel applicationDetailPanel;
    private ApplicationListObject applicationListObject;
    private ButtonArea btnArea;
    private QueryConnector query;
    private CurrentlyLoggedInUser user;
    private ApplicationInfo appInfo;


    public ApplicationContentPanel(BaseWindow window, ApplicationDetailPanel appDP, ApplicationListObject appObject, ApplicationInfo appInfo) {
        super(window, appInfo.getImage());
        this.appInfo = appInfo;
        this.applicationDetailPanel = appDP;
        this.applicationListObject = appObject;
        query = window.getQueryConnector();
        user = query.getCurrentlyLoggedInUser();

        if (user.isRealtor()) {
            btnArea = new ButtonAreaApplicationsRealtor(window, applicationListObject);
        } else {
            btnArea = new ButtonAreaApplicationsConsumer(window, applicationListObject);
        }

        setBtnArea(btnArea);

        buildImgArea(getImageName(), appObject.getHouseID());
        add(getImgArea());
        add(applicationDetailPanel);
        add(btnArea);


    }
}
