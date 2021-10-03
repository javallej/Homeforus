package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ContentPanel extends JPanel {

    private String image;
    private DetailPanel detailPanel;
    private ButtonArea btnArea;
    private BaseWindow window;
    private JPanel imgArea;

    public ContentPanel(BaseWindow window, String image) {
        this.window = window;
        this.image = image;
        setPreferredSize(new Dimension(890,150));
        setBorder(new MatteBorder(2,2,2,2, Color.black));

//        TestingPanel testingPanel = new TestingPanel(window);
//        add(testingPanel);

        imgArea = new JPanel();
        imgArea.setPreferredSize(new Dimension(200,130));
        add(imgArea);
        detailPanel = new DetailPanel();
        add(detailPanel);
        btnArea = new ButtonArea();
        add(btnArea);

        imgArea.setBorder(debugBorder());
        detailPanel.setBorder(debugBorder());
        btnArea.setBorder(debugBorder());
    }

    public static MatteBorder debugBorder() {

        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }
}
