package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;
import main.java.homeforus.core.CurrentlyLoggedInUser;

public class ApplicationContentPanel extends ContentPanel {

    private ApplicationDetailPanel applicationDetailPanel;
    private ApplicationListObject applicationListObject;
    private ButtonArea btnArea;
    private QueryConnector query;
    private CurrentlyLoggedInUser user;

    public ApplicationContentPanel(BaseWindow window, ApplicationDetailPanel appDP, ApplicationListObject appObject, String img) {
        super(window, img);
        this.applicationDetailPanel = appDP;
        this.applicationListObject = appObject;
        query = window.getQueryConnector();
        user = query.getCurrentlyLoggedInUser();

        if (user.isRealtor()) {
            btnArea = new ButtonAreaApplicationsRealtor(window, applicationListObject);
        } else {
            btnArea = new ButtonAreaApplicationsConsumer(window, applicationListObject);
        }

        ButtonAreaApplicationsConsumer btnArea = new ButtonAreaApplicationsConsumer(window, appObject);
        setBtnArea(btnArea);


//        applicationDetailPanel = new ApplicationDetailPanel(appInfo, window);


    }
}
