package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class HouseDetailWindow extends JFrame {

    int width;
    int height;
    BaseWindow window;
    private JButton appBtn;
    HouseDetailPanel houseDetail;
    boolean userIsConsumer;
    HouseContentPanel caller;

    public HouseDetailWindow(BaseWindow window, HouseContentPanel caller, HouseDetailPanel houseDetail) {
        this.window = window;
        this.houseDetail = houseDetail;
        this.caller = caller;
        this.width = 600;
        this.height = 600;
        setPreferredSize(new Dimension(width,height));
    }

    public void buildHouseDetailWindow() {

        JPanel contentHolder = new JPanel();
        contentHolder.setPreferredSize(new Dimension(width - 20, height - 20));
        contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.PAGE_AXIS));

        JPanel imageHolder = new JPanel();
        houseDetail.gethLO().getRealtorID();
        // set size of panel here
        Image houseImage = null;
        Image placeholderImg = null;

        try {
            houseImage = caller.getImgL();
                if (houseImage != null) {
                    ImageIcon ic = new ImageIcon(houseImage);
                    ic.setImage(ic.getImage().getScaledInstance(width - 100, height - 300, Image.SCALE_DEFAULT));
                    imageHolder.add(new JLabel(ic));
                } else {
                    placeholderImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/houses/placeholder.jpg")));
                    imageHolder.add(new JLabel(new ImageIcon(placeholderImg)));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // set size of panel here

        JPanel submitAppHolder = new JPanel();
        // set size of panel here

        appBtn = new JButton("Submit Application");
        submitAppHolder.add(appBtn);

        showAppBtn();

        appBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.getQueryConnector().getCurrentlyLoggedInUser() != null) {
                    try {
                        window.getQueryConnector().createNewApplication(houseDetail.getHouseID(), houseDetail.gethLO().getRealtorID(), houseDetail.gethLO().getRealtorUsername());
                    } catch (SQLException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        add(contentHolder);
        contentHolder.add(imageHolder);
        HouseDetailPanel houseDetailPanel = new HouseDetailPanel(houseDetail.gethLO());
        contentHolder.add(houseDetailPanel);
        contentHolder.add(submitAppHolder);
        setTitle("Viewing House Detail");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public HouseDetailPanel getHouseDetail() {
        return houseDetail;
    }

    public void setHouseDetail(HouseDetailPanel houseDetail) {
        this.houseDetail = houseDetail;
    }

    public void showAppBtn() {
        if (window.getQueryConnector().getCurrentlyLoggedInUser() != null) {
            userIsConsumer = !window.getQueryConnector().getCurrentlyLoggedInUser().isRealtor();
        } else {
            userIsConsumer = false;
        }
        appBtn.setVisible(userIsConsumer);
    }
}
