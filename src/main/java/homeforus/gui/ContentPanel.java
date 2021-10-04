package main.java.homeforus.gui;

import main.java.homeforus.core.ImageEdit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ContentPanel extends JPanel {

    private Image imgL;
    private String imageName;
    private DetailPanel detailPanel;
    private ButtonArea btnArea;
    private BaseWindow window;
    private JPanel imgArea;

    public ContentPanel(BaseWindow window, String imageName) {
        this.window = window;
        this.imageName = imageName;
        setPreferredSize(new Dimension(890,150));
        setBorder(new MatteBorder(1,1,1,1, Color.gray));

//        TestingPanel testingPanel = new TestingPanel(window);
//        add(testingPanel);
    }

    public void buildImgArea(String imgName, int houseID) {
        imgArea = new JPanel();
        Dimension imgDim = new Dimension(200,130);
        imgArea.setPreferredSize(imgDim);

        Image testerImg = null;
        ImageEdit editimage = new ImageEdit();
        InputStream storeimage = null;

//        try {
//            storeimage = editimage.getImage(imgName, houseID);
//
//            if(storeimage != null) {
//                ImageIcon img = new ImageIcon(ImageIO.read(storeimage));
//                imgL = img.getImage();
//                img.setImage(img.getImage().getScaledInstance(imgDim.width, imgDim.height, Image.SCALE_DEFAULT));
//                imgArea.add(new JLabel(new ImageIcon(img.getImage())));
//            }
//            else {
//                System.out.println("Image not found: " + "imgName: " + imgName + "houseID: " + houseID);
//                testerImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/houses/placeholder.jpg")));
//                imgL = testerImg;
//                imgArea.add(new JLabel(new ImageIcon(imgL)));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public Image getImgL() {
        return imgL;
    }

    public void setImgL(Image imgL) {
        this.imgL = imgL;
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
