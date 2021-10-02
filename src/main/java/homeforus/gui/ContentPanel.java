package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ContentPanel extends JPanel {

    public ContentPanel() {
        setPreferredSize(new Dimension(890,150));
        setBorder(new MatteBorder(2,2,2,2, Color.black));

        DetailPanel detailPanel = new DetailPanel();
        add(detailPanel);

        detailPanel.setBorder(debugBorder());
    }

    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }
}
