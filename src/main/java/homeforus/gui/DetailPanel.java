package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DetailPanel extends JPanel {

    private JLabel topRow;
    private JLabel secondRow;
    private JLabel lastRow;

    public DetailPanel() {

        setPreferredSize(new Dimension(540,130));
        add(new JLabel("test"));

        setBorder(debugBorder());

    }


    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
