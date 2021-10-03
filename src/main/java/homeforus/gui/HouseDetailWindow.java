package main.java.homeforus.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        appBtn = new JButton("Submit Application");
        submitAppHolder.add(appBtn);

        showAppBtn();


        appBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.getQueryConnector().getCurrentlyLoggedInUser() != null) {
                    try {
                        window.getQueryConnector().createNewApplication(10);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        contentHolder.add(imageHolder);
        contentHolder.add(houseDetail);
        contentHolder.add(submitAppHolder);
        return contentHolder;
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
