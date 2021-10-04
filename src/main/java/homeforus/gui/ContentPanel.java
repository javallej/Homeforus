package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ContentPanel extends JPanel {

    private String imageName;
    private DetailPanel detailPanel;
    private ButtonArea btnArea;
    private BaseWindow window;
    private JPanel imgArea;
    private HouseDetailWindow houseDetailWindow;

    public ContentPanel(BaseWindow window, String imageName) {
        this.window = window;
        this.imageName = imageName;
        houseDetailWindow = new HouseDetailWindow(window, null);
        setPreferredSize(new Dimension(890,150));
        setBorder(new MatteBorder(1,1,1,1, Color.gray));

//        TestingPanel testingPanel = new TestingPanel(window);
//        add(testingPanel);
        buildContentPanel();
    }

    public void buildContentPanel() {
        imgArea = new JPanel();
        Dimension imgDim = new Dimension(200,130);
        imgArea.setPreferredSize(imgDim);
        // put code to put image from string here

        Image testerImg = null;

        try {
            testerImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/houses/placeholder.jpg")));
            testerImg = testerImg.getScaledInstance(imgDim.width, imgDim.height, Image.SCALE_DEFAULT);
            imgArea.add(new JLabel(new ImageIcon(testerImg)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(imgArea);


        detailPanel = new DetailPanel();
        add(detailPanel);
        btnArea = new ButtonArea(window);
        add(btnArea);
    }

    public HouseDetailWindow getHouseDetailWindow() {
        return houseDetailWindow;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public DetailPanel getDetailPanel() {
        return detailPanel;
    }

    public void setDetailPanel(DetailPanel detailPanel) {
        this.detailPanel = detailPanel;
    }

    public ButtonArea getBtnArea() {
        return btnArea;
    }

    public void setBtnArea(ButtonArea btnArea) {
        this.btnArea = btnArea;
    }

    public BaseWindow getWindow() {
        return window;
    }

    public void setWindow(BaseWindow window) {
        this.window = window;
    }

    public JPanel getImgArea() {
        return imgArea;
    }

    public void setImgArea(JPanel imgArea) {
        this.imgArea = imgArea;
    }

    public static MatteBorder debugBorder() {

        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }
}
