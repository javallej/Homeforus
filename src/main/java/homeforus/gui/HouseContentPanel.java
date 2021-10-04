package main.java.homeforus.gui;

public class HouseContentPanel extends ContentPanel {

    private HouseDetailWindow houseDetailWindow;

    public HouseContentPanel(BaseWindow window, String image, HouseDetailPanel hDP) {
        super(window, image);
        setDetailPanel(hDP);
        houseDetailWindow = new HouseDetailWindow(window, hDP);

        // build House content panel here
        buildImgArea(image, hDP.getHouseID());
        add(getImgArea());
        add(getDetailPanel());
        setBtnArea(new ButtonArea(window));
        add(getBtnArea());
    }
}
