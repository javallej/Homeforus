package main.java.homeforus.gui;

public class ApplicationContentPanel extends ContentPanel {

    private ApplicationDetailPanel applicationDetailPanel;
    private String image;

    public ApplicationContentPanel(BaseWindow window, ApplicationDetailPanel appDP, String img) {
        super(window, img);
        this.applicationDetailPanel = appDP;
    }
}
