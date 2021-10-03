package main.java.homeforus.gui;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DetailPanel extends JPanel {

    private JLabel row1;
    private JLabel row2;
    private JLabel row3;
    private JLabel row4;
    private JLabel row5;


    public DetailPanel() {

        row1 = new JLabel("Price");
        row2 = new JLabel("HouseInfo");
        row3 = new JLabel( "some other stuff");
        row4 = new JLabel("row 4 information");
        row5 = new JLabel("row 5 information");
        setPreferredSize(new Dimension(540,130));
        setLayout(new GridLayout(5,0));
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);

        setBorder(debugBorder());

    }


    public static MatteBorder debugBorder() {
        return new MatteBorder(3, 3, 3, 3, Color.CYAN);
    }

}
