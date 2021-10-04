package main.java.homeforus.gui;

import java.awt.event.*;

public class HouseContentPanel extends ContentPanel {

    private HouseDetailPanel houseDetailPanel;
    private HouseDetailWindow houseDetailWindow;
    private ContentPanel t;

    public HouseContentPanel(BaseWindow window, String image, HouseDetailPanel hDP) {
        super(window, image);
        this.houseDetailPanel = hDP;
        t = this;
        houseDetailWindow = new HouseDetailWindow(window, this, hDP);

        // build House content panel here
        buildImgArea(image, hDP.getHouseID());
        add(getImgArea());
        add(hDP);
        setBtnArea(new ButtonArea(window));
        add(getBtnArea());


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                t.setDetailPanel(houseDetailPanel);
                houseDetailWindow.buildHouseDetailWindow();
                if (!houseDetailWindow.isVisible()) {
                    houseDetailWindow.setVisible(true);
                }
            }
        });
    }

    public HouseDetailPanel getHouseDetailPanel() {
        return houseDetailPanel;
    }
}
