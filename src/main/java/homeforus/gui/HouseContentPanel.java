package main.java.homeforus.gui;

import java.awt.event.*;

public class HouseContentPanel extends ContentPanel {

    private int houseID;
    private ButtonArea btnArea;
    private HouseDetailPanel houseDetailPanel;
    private HouseDetailWindow houseDetailWindow;
    private ContentPanel t;

    public HouseContentPanel(BaseWindow window, String image, HouseDetailPanel hDP) {
        super(window, image);
        this.houseDetailPanel = hDP;
        houseID = houseDetailPanel.getHouseID();
        t = this;
        houseDetailWindow = new HouseDetailWindow(window, this, hDP);

        // build House content panel here
        buildImgArea(image, hDP.getHouseID());
        add(getImgArea());
        add(hDP);
        btnArea = new ButtonArea(window);
        setBtnArea(btnArea);
        add(btnArea);


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

    @Override
    public void setBtnArea(ButtonArea btnArea) {
        this.btnArea = btnArea;
    }

    @Override
    public ButtonArea getBtnArea() {
        return btnArea;
    }

    public void removeBtnArea() {
        remove(btnArea);
    }

    public HouseDetailPanel getHouseDetailPanel() {
        return houseDetailPanel;
    }

    public int getHouseID() {
        return houseID;
    }
}
