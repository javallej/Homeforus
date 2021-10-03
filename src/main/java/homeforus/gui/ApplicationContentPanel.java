package main.java.homeforus.gui;

import main.java.homeforus.core.ApplicationListObject;

public class ApplicationContentPanel extends ContentPanel {

    private ApplicationDetailPanel applicationDetailPanel;
    private String image;
    private ApplicationListObject applicationListObject;

    public ApplicationContentPanel(BaseWindow window, ApplicationDetailPanel appDP, ApplicationListObject appObject, String img) {
        super(window, img);
        this.applicationDetailPanel = appDP;
        this.applicationListObject = appObject;
        ButtonAreaApplicationsConsumer btnArea = new ButtonAreaApplicationsConsumer(window, appObject);
        setBtnArea(btnArea);
        // TODO: need to call a queryconnector method here that converts an ApplicationListObject into an ApplicationInfo object

//        ApplicationDetailPanel applicationDetailPanel = new ApplicationDetailPanel(null, window);

    }
}
