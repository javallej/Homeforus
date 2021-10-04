package main.java.homeforus.gui;

public class HouseContentPanel extends ContentPanel {

    private HouseDetailPanel houseDetailPanel;

    public HouseContentPanel(BaseWindow window, String image, HouseDetailPanel hDP) {
        super(window, image);
        this.houseDetailPanel = hDP;

        // build House content panel here
    }
}
