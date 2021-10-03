package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HouseDetailWindow extends JFrame {

    int width;
    int height;
    BaseWindow window;
    HouseDetailPanel houseDetail;
    boolean userIsConsumer;

    public HouseDetailWindow(BaseWindow window, HouseDetailPanel houseDetail) {
        this.window = window;
        this.houseDetail = houseDetail;
        this.width = 600;
        this.height = 600;
        setPreferredSize(new Dimension(width,height));
        add(buildHouseDetailWindow());
        setTitle("Viewing House Detail");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel buildHouseDetailWindow() {
        JPanel contentHolder = new JPanel();
        contentHolder.setPreferredSize(new Dimension(width - 20, height - 20));
        contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.PAGE_AXIS));

        JPanel imageHolder = new JPanel();
        // set size of panel here
        Image testerImg = null;
        try {
            testerImg = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/homeforus/houses/placeholder.jpg")));
            imageHolder.add(new JLabel(new ImageIcon(testerImg)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        houseDetail = new HouseDetailPanel(null);
        // set size of panel here

        JPanel submitAppHolder = new JPanel();
        // set size of panel here

        JButton submitAppBtn = new JButton("Submit Application");
        submitAppHolder.add(submitAppBtn);

        if (window.getQueryConnector().getCurrentlyLoggedInUser() != null) {
            userIsConsumer = window.getQueryConnector().getCurrentlyLoggedInUser().isRealtor();
        } else {
            userIsConsumer = false;
        }

        showAppBtn(submitAppBtn, userIsConsumer);

        contentHolder.add(imageHolder);
        contentHolder.add(houseDetail);
        contentHolder.add(submitAppHolder);
        return contentHolder;
    }

    // make a method that hides this when user is not logged in as a Consumer
    private void showAppBtn(JButton appBtn, boolean consumerView) {
        if (userIsConsumer) {
            appBtn.setVisible(true);
        } else {
            appBtn.setVisible(false);
        }
    }
}
